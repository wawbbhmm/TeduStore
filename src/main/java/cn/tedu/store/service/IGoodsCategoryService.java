package cn.tedu.store.service;

import cn.tedu.store.bean.GoodsCategory;

import java.util.List;

public interface IGoodsCategoryService {

    /**
     * 根据父级id查询子分类
     * @param parentId
     * @param offset
     * @param count
     * @return
     */
    List<GoodsCategory> getCategoryByParentId(Integer parentId, Integer offset, Integer count);

}
