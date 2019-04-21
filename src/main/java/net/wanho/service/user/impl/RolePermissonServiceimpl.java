package net.wanho.service.user.impl;

import net.wanho.mapper.RolepermissionMapper;
import net.wanho.pojo.Rolepermission;
import net.wanho.service.user.RolePermissonService;
import org.springframework.beans.factory.annotation.Autowired;

public class RolePermissonServiceimpl implements RolePermissonService {

    @Autowired
    private RolepermissionMapper rolepermissionMapper;


    @Override
    public Long deleteByPrimaryKey(Long tid) {
        return rolepermissionMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Long insert(Rolepermission record) {
        return rolepermissionMapper.insert(record);
    }

    @Override
    public Long insertSelective(Rolepermission record) {
        return rolepermissionMapper.insertSelective(record);
    }

    @Override
    public Rolepermission selectByPrimaryKey(Long tid) {
        return rolepermissionMapper.selectByPrimaryKey(tid);
    }

    @Override
    public Long updateByPrimaryKeySelective(Rolepermission record) {
        return rolepermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long updateByPrimaryKey(Rolepermission record) {
        return rolepermissionMapper.updateByPrimaryKey(record);
    }
}