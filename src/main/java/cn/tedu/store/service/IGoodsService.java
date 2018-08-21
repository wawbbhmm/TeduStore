package cn.tedu.store.service;

import cn.tedu.store.bean.Goods;

import java.util.List;

public interface IGoodsService {

    /**
     * 获取热门商品
     * @param categoryId
     * @param offset
     * @param count
     * @return
     */
    List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count);

    /**
     * 根据分类id获取记录数
     * @param categoryId
     * @return
     */
    Integer getCount(Integer categoryId);

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    Goods getGoodsById(String id);

}
