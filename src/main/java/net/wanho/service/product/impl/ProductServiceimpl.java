package net.wanho.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.mapper.ProductMapper;
import net.wanho.pojo.Product;
import net.wanho.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public PageInfo<Product> selectProductbyEntity(Integer start,Integer limit,Integer navigatePages) {
        PageHelper.startPage(start, limit);
        List<Product> products = productMapper.selectProductbyEntity();
        PageInfo<Product> pageinfo=new PageInfo<Product>(products,navigatePages);
        return pageinfo;
    }

    @Override
    public Long deleteByPrimaryKey(Long tid) {
        return productMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Long insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public Long insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Long tid) {
        return productMapper.selectByPrimaryKey(tid);
    }

    @Override
    public Long updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }
}
