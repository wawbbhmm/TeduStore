package test;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCart {

    @Test
    public void testInsertCart(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        CartMapper cm = ac.getBean("cartMapper", CartMapper.class);
        Cart cart = new Cart();
        cart.setUid(3);
        cart.setGoodsId("10000000");
        cart.setNum(10);
        cm.insertCart(cart);
    }

    @Test
    public void testSelectByUid(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        CartMapper cm = ac.getBean("cartMapper", CartMapper.class);
        System.out.println(cm.selectCartByUid(5));
    }

    @Test
    public void testDelByBatch(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        CartMapper cm = ac.getBean("cartMapper", CartMapper.class);
        cm.deleteByBatch(new Integer[]{4,5});
    }

    @Test
    public void testDelById(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        CartMapper cm = ac.getBean("cartMapper", CartMapper.class);
        cm.deleteById(11);
    }

    @Test
    public void testUpdateById(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        CartMapper cm = ac.getBean("cartMapper", CartMapper.class);
        cm.updateById(8, 12);
    }

}
