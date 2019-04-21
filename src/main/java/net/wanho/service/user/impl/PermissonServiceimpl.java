package net.wanho.service.user.impl;

import net.wanho.mapper.PermissionMapper;
import net.wanho.pojo.Permission;
import net.wanho.service.user.PermissonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PermissonServiceimpl implements PermissonService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Long deleteByPrimaryKey(Long tid) {
        return permissionMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Long insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public Long insertSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Long tid) {
        return permissionMapper.selectByPrimaryKey(tid);
    }

    @Override
    public Long updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }
}
