package net.wanho.mapper.base;

public interface BaseMapper<T> {
    Long deleteByPrimaryKey(Long tid);

    Long insert(T record);

    Long insertSelective(T record);

    T selectByPrimaryKey(Long tid);

    Long updateByPrimaryKeySelective(T record);

    Long updateByPrimaryKey(T record);

}
