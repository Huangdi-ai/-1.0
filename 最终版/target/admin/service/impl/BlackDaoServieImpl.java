package com.admin.service.impl;

import com.admin.dao.BlackDao;
import com.admin.service.BlackService;

import com.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlackDaoServieImpl implements BlackService {
    @Autowired
    BlackDao blackDao;
    @Override
    public List<User> getBlack() { return blackDao.getBlack(); }
    @Override
    public boolean recover(int id){ return blackDao.recover(id);}
}
