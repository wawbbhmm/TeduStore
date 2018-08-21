package test;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.IGoodsCategoryService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCategory {

    @Test
    public void testSelectCategory(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        GoodsCategoryMapper cm = ac.getBean("goodsCategoryMapper", GoodsCategoryMapper.class);
        // 二级分类
        List<GoodsCategory> list = cm.selectCategoryByParentId(161, 0, 3);
        System.out.println(list);
        // 三级分类
        for (GoodsCategory cc : list) {
            System.out.println(cm.selectCategoryByParentId(cc.getId(), null, null).size());
        }
        ac.close();
    }

    @Test
    public void testGetCategory(){
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-dao.xml",
                "spring-service.xml");
        IGoodsCategoryService cs = ac.getBean("goodsCategoryService", IGoodsCategoryService.class);
        List<GoodsCategory> list2 = cs.getCategoryByParentId(161, 0, 3);
        System.out.println(list2);
        for (GoodsCategory cc : list2) {
            System.out.println(cs.getCategoryByParentId(cc.getId(), null, null).size());
        }
        ac.close();
    }


}
