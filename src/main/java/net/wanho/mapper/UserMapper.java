package net.wanho.mapper;

import net.wanho.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long tid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long tid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User queryexUser(User user);
}