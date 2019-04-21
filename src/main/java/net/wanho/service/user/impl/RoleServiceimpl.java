package net.wanho.service.user.impl;

import net.wanho.mapper.RoleMapper;
import net.wanho.pojo.Role;
import net.wanho.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Long deleteByPrimaryKey(Long tid) {
        return roleMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Long insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public Long insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Long tid) {
        return roleMapper.selectByPrimaryKey(tid);
    }

    @Override
    public Long updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
