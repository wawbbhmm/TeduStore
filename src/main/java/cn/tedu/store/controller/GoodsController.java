package cn.tedu.store.controller;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

    @Resource
    private IGoodsService goodsService;

    /**
     * 显示商品页面
     * @param categoryId
     * @param page
     * @param map
     * @return
     */
    @RequestMapping("/showSearch.do")
    public String showSearch(Integer categoryId, Integer page, ModelMap map){
        // 在index.jsp页面的三级分类连接到页面时，page是null
        if(page == null){
            page = 1;
        }
        //1.计算offset
        Integer offset = (page - 1)*16;
        //2.调用业务层方法
        List<Goods> list = goodsService.getGoodsByCategoryId(categoryId, offset, 16);
        //3.把list添加到map对象中
        map.addAttribute("goodsList", list);
        //4.在map中添加记录数
        Integer count = goodsService.getCount(categoryId);
        map.addAttribute("count", count);
        //5.共?页
        Integer pages = count%16==0?count/16:count/16+1;
        map.addAttribute("pages", pages);
        //6.把categoryId添加到map对象中
        map.addAttribute("categoryId", categoryId);
        //7.设置当前页
        map.addAttribute("curpage", page);
        return "search";
    }

    /**
     * 显示商品详情页
     * @return
     */
    @RequestMapping("/showProductDetails.do")
    public String showProductDetails(String id, ModelMap map){
        //1.调用业务层方法;返回goods对象
        Goods goods = goodsService.getGoodsById(id);
        //2.把goods对象添加到map对象中
        map.addAttribute("goods", goods);
        return "product_details";
    }



}
