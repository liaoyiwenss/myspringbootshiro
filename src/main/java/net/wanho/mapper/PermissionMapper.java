package net.wanho.mapper;

import net.wanho.mapper.base.BaseMapper;
import net.wanho.pojo.Permission;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectRoleandPermission(Long roleid);
}