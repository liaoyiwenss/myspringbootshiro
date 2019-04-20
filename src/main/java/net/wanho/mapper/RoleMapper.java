package net.wanho.mapper;

import net.wanho.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long tid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}