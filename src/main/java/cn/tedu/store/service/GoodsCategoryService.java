package cn.tedu.store.service;

import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsCategoryService implements IGoodsCategoryService {

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public List<GoodsCategory> getCategoryByParentId(Integer parentId, Integer offset, Integer count) {
        // 调用持久的方法,返回集合
        return goodsCategoryMapper.selectCategoryByParentId(parentId, offset, count);
    }






}
