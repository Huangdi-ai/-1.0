package com.bbs.service.impl;

import com.bbs.dao.UserDao;
import com.bbs.service.UserserService;
import com.common.pojo.Post;
import com.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceimpl implements UserserService {
    @Autowired
    private UserDao userdao;
    @Override
    public int regist(User user) {
        userdao.regist(user);
        return 0;
    }

    @Override
    public int login(String username, String password) {
        int users = userdao.login(username,password);

            return 0;
    }

    @Override
    public int isExist(User user) {
        return userdao.isExist(user);
    }

    @Override
    public int activeUser(String code) {
        return userdao.activeUser(code);
    }

    @Override
    public void updateCode(String username, String code) {
        userdao.updateCode(username,code);
    }

    @Override
    public void update(User user) {

        userdao.update(user);
    }

    @Override
    public int getUserIdByUsername(String username) {
        return userdao.getUserIdByUsername(username);
    }



    @Override
    public User getUserById(Integer integer) {
        User user=userdao.getUserById(integer);
        return user;
    }
    @Override
    public int getUserIdByEmail(String email) {
        return userdao.getUserByEmail(email);
    }

    @Override
    public List<Post> getUserPost(int userId) {
        return userdao.getUserPost(userId);
    }

}
