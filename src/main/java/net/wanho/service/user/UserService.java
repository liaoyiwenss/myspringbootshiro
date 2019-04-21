package net.wanho.service.user;

import net.wanho.pojo.User;
import net.wanho.service.base.BaseService;

public interface UserService extends BaseService<User> {

    User queryexUser(User user);
}
