package net.wanho.service.product;


import net.wanho.pojo.Productcategory;
import net.wanho.pojo.vo.ProductCategoryVO;
import net.wanho.service.base.BaseService;

import java.util.List;

public interface ProductCategoryService extends BaseService<Productcategory> {

    public List<ProductCategoryVO> getDomList();
}
