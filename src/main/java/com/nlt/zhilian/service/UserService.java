package com.nlt.zhilian.service;

import com.nlt.zhilian.pojo.User;

public interface UserService {

    /**
     * 登录
     *
     * @param user
     * @return User
     */
    User login(User user);

    /**
     * 注册
     *
     * @param user
     * @return int
     */
    int register(User user);

}
