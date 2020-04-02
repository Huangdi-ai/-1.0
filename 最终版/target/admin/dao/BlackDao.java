package com.admin.dao;


import com.common.pojo.User;


import java.util.List;

public interface BlackDao {
    public List<User> getBlack();

    boolean recover(int id);

}
