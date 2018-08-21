package cn.tedu.store.service;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 省市几乎不修改，但经常查询，应放在Redis中缓冲
 * 加同步，避免两线程并发时查两次数据库
 */
@Service
public class DictService implements IDictService {

    @Resource
    private DictMapper dictMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public synchronized List<Province> getProvince() {
        // 先查询Redis中是否有省份列表 消除警告注解
        @SuppressWarnings("unchecked")
        List<Province> list = (List<Province>) redisTemplate.opsForValue().get("provinceList");
        // 如果在Redis中没有查到省份列表
        if(list == null){
            // 在数据库中查询 省份列表
            list = dictMapper.selectProvince();
            System.out.println("查询省份列表 - Redis优化");
            /*
             * 缓存到Redis中，为了下次查询，1天过期
             * 如果是频繁修改的数据，避免数据库和Redis数据不一致，需要把过期时间改为1小时
             */
            redisTemplate.opsForValue().set("provinceList", list, 1, TimeUnit.DAYS);
        }
        return list;
    }

    @Override
    public synchronized List<City> getCity(String provinceCode) {
        // Key可自己定义唯一的key，用"province"+provinceCode当key去查询
        @SuppressWarnings("unchecked")
        List<City> cities = (List<City>) redisTemplate.opsForValue().get("province"+provinceCode);
        if(cities == null){
            cities = dictMapper.selectCity(provinceCode);
            redisTemplate.opsForValue().set("getCity", cities, 1, TimeUnit.DAYS);
        }
        return cities;
    }

    @Override
    public synchronized List<Area> getArea(String cityCode) {
        @SuppressWarnings("unchecked")
        List<Area> areas = (List<Area>) redisTemplate.opsForValue().get("city"+cityCode);
        if(areas == null){
            areas = dictMapper.selectArea(cityCode);
            redisTemplate.opsForValue().set("getArea", areas, 1, TimeUnit.DAYS);
        }
        return areas;
    }

}
