package net.wanho.mapper;

import net.wanho.pojo.Rolepermission;

public interface RolepermissionMapper {
    int deleteByPrimaryKey(Long tid);

    int insert(Rolepermission record);

    int insertSelective(Rolepermission record);

    Rolepermission selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(Rolepermission record);

    int updateByPrimaryKey(Rolepermission record);
}