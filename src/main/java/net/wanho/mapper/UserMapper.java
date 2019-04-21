package net.wanho.mapper;

import net.wanho.mapper.base.BaseMapper;
import net.wanho.pojo.User;

public interface UserMapper extends BaseMapper<User> {

    User queryexUser(User user);
}