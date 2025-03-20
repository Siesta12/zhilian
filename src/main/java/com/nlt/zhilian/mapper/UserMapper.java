package com.nlt.zhilian.mapper;

import com.nlt.zhilian.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param username
     * @param password
     * @return User
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 注册
     * @param username
     * @param password
     * @param userType
     * @return int
     */
    @Insert("insert into user(username, password, userType) values(#{username}, #{password}, #{userType})")
    int register(@Param("username") String username, @Param("password") String password, @Param("userType") String userType);

}
