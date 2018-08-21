package cn.tedu.store.service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.vo.CartVo;

import java.util.List;

public interface ICartService {

    /**
     * 添加购物车数据
     * @param cart
     */
    void addCart(Cart cart);

    /**
     * 获取购物车信息
     * @param uid
     * @return
     */
    List<CartVo> getCartByUid(Integer uid);

    /**
     * 批量删除
     * @param ids
     */
    void delByBatch(Integer[] ids);

    /**
     * 单行删除
     * @param id
     */
    void delById(Integer id);

    /**
     * 修改商品数量
     * @param num
     * @param id
     */
    void updateById(Integer num, Integer id);

}
