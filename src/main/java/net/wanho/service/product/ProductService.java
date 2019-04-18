package net.wanho.service.product;

import com.github.pagehelper.PageInfo;
import net.wanho.pojo.Product;
import net.wanho.service.base.BaseService;

public interface ProductService extends BaseService<Product> {

    public PageInfo<Product> selectProductbyEntity(Integer start,Integer limit,Integer navigatePages);

}
