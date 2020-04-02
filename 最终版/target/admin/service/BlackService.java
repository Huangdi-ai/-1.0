package com.admin.service;


import com.common.pojo.User;

import java.util.List;

public interface BlackService {
    List<User> getBlack();
    public boolean recover(int id);
}
