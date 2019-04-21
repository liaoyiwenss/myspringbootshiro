package net.wanho.service.user.impl;

import net.wanho.mapper.UserroleMapper;
import net.wanho.pojo.Userrole;
import net.wanho.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRoleServiceimpl implements UserRoleService {

    @Autowired
    private UserroleMapper userroleMapper;

    @Override
    public Long deleteByPrimaryKey(Long tid) {
        return userroleMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Long insert(Userrole record) {
        return userroleMapper.insert(record);
    }

    @Override
    public Long insertSelective(Userrole record) {
        return userroleMapper.insertSelective(record);
    }

    @Override
    public Userrole selectByPrimaryKey(Long tid) {
        return userroleMapper.selectByPrimaryKey(tid);
    }

    @Override
    public Long updateByPrimaryKeySelective(Userrole record) {
        return userroleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long updateByPrimaryKey(Userrole record) {
        return userroleMapper.updateByPrimaryKeySelective(record);
    }
}
