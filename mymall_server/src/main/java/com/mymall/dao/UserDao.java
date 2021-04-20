package com.mymall.dao;

import com.mymall.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUserByMessage(
            @Param("login_tel") String login_tel,
            @Param("login_password") String login_password
    );
}
