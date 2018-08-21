package cn.tedu.store.mapper;

import cn.tedu.store.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    /**
     * 查询热卖商品
     * @param categoryId
     * @param offset
     * @param count
     * @return
     */
    List<Goods> selectGoodsByCategoryId(
            @Param("categoryId") Integer categoryId,
            @Param("offset") Integer offset,
            @Param("count") Integer count);

    /**
     * 根据分类id获取记录数
     * @param categoryId
     * @return
     */
    Integer selectCount(Integer categoryId);

    /**
     * 查询商品信息
     * @param id
     * @return
     */
    Goods selectGoodsById(String id);


}
