package net.wanho.service.product.impl;

import net.wanho.mapper.ProductcategoryMapper;
import net.wanho.pojo.Productcategory;
import net.wanho.service.product.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceimpl implements ProductCategoryService {

    @Autowired
    private ProductcategoryMapper productcategoryMapper;


    @Override
    public int deleteByPrimaryKey(Long tid) {
        return productcategoryMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Productcategory record) {
        return productcategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Productcategory record) {
        return productcategoryMapper.insertSelective(record);
    }

    @Override
    public Productcategory selectByPrimaryKey(Long tid) {
        return productcategoryMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(Productcategory record) {
        return productcategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Productcategory record) {
        return productcategoryMapper.updateByPrimaryKey(record);
    }
}
