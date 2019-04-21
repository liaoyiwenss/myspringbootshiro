package net.wanho.service.base;

public interface BaseService<T> {

    Long deleteByPrimaryKey(Long tid);

    Long insert(T record);

    Long insertSelective(T record);

    T selectByPrimaryKey(Long tid);

    Long updateByPrimaryKeySelective(T record);

    Long updateByPrimaryKey(T record);
}
