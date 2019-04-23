package net.wanho.service.user.impl;

import net.wanho.mapper.*;
import net.wanho.pojo.*;
import net.wanho.service.user.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserroleMapper userroleMapper;

    @Autowired
    private RolepermissionMapper rolepermissionMapper;

    @Override
    public int deleteByPrimaryKey(Long tid) {
        return userMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long tid) {
        return userMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User queryexUser(User user) {
        return userMapper.queryexUser(user);
    }

    @Override
    public String shiroMD5(String password, String salt) {
        String algorithmName="md5";
        ByteSource bytes = ByteSource.Util.bytes(salt);
        int hashIterations=2;
        Object object = new SimpleHash(algorithmName, password, bytes, hashIterations);
        return object.toString();
    }


    public User addUser(User user){
        Role role=new Role();
        Permission permission=new Permission();
       /* if(type==0)
        {
            role.setRolename("admin");
            permission.setPermissionname("user:*");
        }else
        {*/
        role.setRolename("user");
        permission.setPermissionname("user:query");
        /*}*/
        userMapper.insert(user);

        roleMapper.insert(role);

        permissionMapper.insert(permission);


        Userrole userrole=new Userrole();
        userrole.setUserid(user.getTid());
        userrole.setRoleid(role.getTid());
        userroleMapper.insert(userrole);
        Rolepermission rolepermission=new Rolepermission();
        rolepermission.setRoleid(role.getTid());
        rolepermission.setPermissionid(permission.getTid());
        rolepermissionMapper.insert(rolepermission);
        return user;
    }
}
