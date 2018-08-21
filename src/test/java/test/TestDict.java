package test;

import cn.tedu.store.bean.Province;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.service.IDictService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDict {

    @Test
    public void testSelectProvince(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        // DictMapper dm = ac.getBean("dictMapper", DictMapper.class);
        // List<Province> list = dm.selectProvince();
        // System.out.println(list.size());
        // System.out.println(list);
        IDictService ds = ac.getBean("dictService", IDictService.class);
        System.out.println(ds.getProvince());
        ac.close();
    }

    @Test
    public void testSelectCity(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        // DictMapper dm = ac.getBean("dictMapper", DictMapper.class);
        IDictService ds = ac.getBean("dictService", IDictService.class);
        System.out.println(ds.getCity("110000"));
        ac.close();
    }

    @Test
    public void testSelectNameByCode(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        DictMapper dm = ac.getBean("dictMapper", DictMapper.class);
        System.out.println(dm.selectProvinceNameByCode("130000"));
        System.out.println(dm.selectCityNameByCode("130100"));
        System.out.println(dm.selectAreaNameByCode("130102"));
        ac.close();
    }

}
