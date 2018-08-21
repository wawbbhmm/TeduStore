package cn.tedu.store.mapper;

import cn.tedu.store.bean.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {

    /**
     * 查询分类信息
     * @param parentId
     * @param offset
     * @param count
     * @return
     */
    List<GoodsCategory> selectCategoryByParentId(
            @Param("parentId") Integer parentId,
            @Param("offset") Integer offset,
            @Param("count") Integer count);

}
