package net.wanho.service.user.impl;

import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import net.wanho.service.user.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long deleteByPrimaryKey(Long tid) {
        return userMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Long insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public Long insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long tid) {
        return userMapper.selectByPrimaryKey(tid);
    }

    @Override
    public Long updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long updateByPrimaryKey(User record) {
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
}
