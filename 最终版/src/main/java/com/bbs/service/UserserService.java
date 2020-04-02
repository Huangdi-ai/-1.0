package com.bbs.service;


import com.common.pojo.Post;
import com.common.pojo.User;

import java.util.List;

public interface UserserService{

    public int regist(User user);
    public int login(String username, String password);

    /**
     * 判断用户的各项信息是否存在，包括用户名，邮箱
     * @param user
     * @return 返回1代表存在相同的用户名，2代表存在相同的邮箱，返回负数代表不存在该用户的信息
     */
    public int isExist(User user);

    /**
     * 激活用户
     * @param code ode 激活码
     * @return 1-激活成功,0-该用户不存在，-1已经激活
     */
    public int activeUser(String code);

    public void updateCode(String username, String code);

    public void update(User user);
    public int getUserIdByUsername(String username);
    public User getUserById(Integer integer);
    public int getUserIdByEmail(String email);

    public List<Post> getUserPost(int userId);
}
