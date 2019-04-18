package net.wanho.mapper;

import net.wanho.mapper.base.BaseMapper;
import net.wanho.pojo.Productcategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductcategoryMapper extends BaseMapper<Productcategory> {


    List<Productcategory> queryProductCategoryListbyParentId(Long parentid);
}