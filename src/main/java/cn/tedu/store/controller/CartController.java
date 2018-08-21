package cn.tedu.store.controller;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.vo.CartVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {

    @Resource
    private ICartService cartService;

    /**
     * 显示购物车
     * @param session
     * @param map
     * @return
     */
    @RequestMapping("/showCart.do")
    public String showCart(HttpSession session, ModelMap map){
        //1.调用业务层方法;返回集合
        List<CartVo> list = cartService.getCartByUid(this.getId(session));
        //2.把集合添加到map对象中
        map.addAttribute("cartVoList", list);
        return "cart";
    }

    /**
     * 添加购物车
     * @param session
     * @param goodsId
     * @param num
     * @return
     */
    @RequestMapping("/addCart.do")
    @ResponseBody
    public ResponseResult<Void> addCart(HttpSession session, String goodsId, Integer num){
        //1.创建rr对象
        ResponseResult<Void> rr = new ResponseResult<>();
        //2.调用业务层方法
        Cart cart = new Cart();
        cart.setUid(this.getId(session));
        cart.setGoodsId(goodsId);
        cart.setNum(num);
        cartService.addCart(cart);
        //3.state=1;message="添加成功"
        rr.setState(1);
        rr.setMessage("添加成功！");
        return rr;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delByBatch.do")
    public String delByBatch(Integer [] ids){
        // 调用业务层方法
        cartService.delByBatch(ids);
        // 重定向
        return "redirect:../cart/showCart.do";
    }

    /**
     * 单行删除
     * @param id
     * @return
     */
    @RequestMapping("/delById.do")
    public String delById(Integer id){
        //1.调用业务层方法
        cartService.delById(id);
        //2.重定向到cart.jsp
        return "redirect:../cart/showCart.do";
    }

    /**
     * 修改商品数量
     * @param num
     * @param id
     * @return
     */
    @RequestMapping("/updateById.do")
    @ResponseBody
    public ResponseResult<Void> updateById(Integer num, Integer id){
        ResponseResult<Void> rr = new ResponseResult<>();
        cartService.updateById(num, id);
        rr.setState(1);
        rr.setMessage("成功！");
        return rr;
    }



}
