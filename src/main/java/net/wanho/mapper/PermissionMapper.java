package net.wanho.mapper;

import net.wanho.pojo.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long tid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}