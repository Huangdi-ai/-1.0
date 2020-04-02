package com.admin.service.impl;


import com.admin.dao.MemberDao;
import com.admin.service.MemberService;
import com.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;
    @Override
    public List<User> getUser() {
        return memberDao.getUser();
    }

    @Override
    public boolean deleteUser(int userId) {
        return memberDao.deleteUser(userId);
    }

    public int batchDelete(List<Integer>postIds){
        return memberDao.batchDelete(postIds);
    }

    public boolean blackUser(int id){ return memberDao.blackUser(id);}
}
