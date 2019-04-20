package net.wanho.mapper;

import net.wanho.pojo.Userrole;

public interface UserroleMapper {
    int deleteByPrimaryKey(Long tid);

    int insert(Userrole record);

    int insertSelective(Userrole record);

    Userrole selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(Userrole record);

    int updateByPrimaryKey(Userrole record);
}