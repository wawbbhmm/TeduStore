package cn.tedu.store.service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService implements IGoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
        return goodsMapper.selectGoodsByCategoryId(categoryId, offset, count);
    }

    @Override
    public Integer getCount(Integer categoryId) {
        return goodsMapper.selectCount(categoryId);
    }

    @Override
    public Goods getGoodsById(String id) {
        return goodsMapper.selectGoodsById(id);
    }


}
