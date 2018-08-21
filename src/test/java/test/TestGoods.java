package test;

import cn.tedu.store.mapper.GoodsMapper;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGoods {

    @Test
    public void testSelectByCid(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        GoodsMapper gm = ac.getBean("goodsMapper", GoodsMapper.class);
        System.out.println(gm.selectGoodsByCategoryId(163, 0, 3));
    }

    @Test
    public void testGetCount(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        GoodsMapper gm = ac.getBean("goodsMapper", GoodsMapper.class);
        System.out.println(gm.selectCount(163));
    }

    @Test
    public void testSelectGoodsById(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        GoodsMapper gm = ac.getBean("goodsMapper", GoodsMapper.class);
        System.out.println(gm.selectGoodsById("10000000"));
    }

}
