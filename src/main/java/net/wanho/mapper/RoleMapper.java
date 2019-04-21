package net.wanho.mapper;

import net.wanho.mapper.base.BaseMapper;
import net.wanho.pojo.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    public List<Role> selectUserandRole(Long userid);
}