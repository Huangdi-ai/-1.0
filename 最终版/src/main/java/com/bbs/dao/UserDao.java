package com.bbs.dao;


import com.common.pojo.Post;
import com.common.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
        public boolean regist(User user);
        public int login(String username, String password);
        public boolean changePassword(int userId, int oldpasswod, int newpassword);
        public void update(User user);
        public User getUserById(Integer integer);
        public int getUserIdByUsername(String username);
        public int  activeUser(String activeCode);
        public void updateCode(String username, String code);
        public int isExist(User user);
        public int getUserByEmail(String email);
        /**
         * 拿到用户的帖子
         */
        public List<Post> getUserPost(int userId);

        public int saveUpdate(User user);
}
