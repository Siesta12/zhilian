package com.nlt.zhilian.service.serviceImpl;

import com.nlt.zhilian.mapper.UserMapper;
import com.nlt.zhilian.pojo.User;
import com.nlt.zhilian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param user
     * @return User
     */
    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        return userMapper.login(username,password);
    }

    /**
     * 注册
     * @param user
     * @return int
     */
    @Override
    public int register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String category = user.getUserType();
        return userMapper.register(username, password, category);
    }

}
