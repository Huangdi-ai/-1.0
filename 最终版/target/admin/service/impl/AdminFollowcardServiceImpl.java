package com.admin.service.impl;

import com.admin.dao.AdminFollowcardDao;
import com.admin.service.AdminFollowcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminFollowcardServiceImpl implements AdminFollowcardService {
    @Autowired
    AdminFollowcardDao adminFollowcardDao;
    @Override
    public List<Map<String,Object>> getAllFollowcards() {
        List<Map<String,Object>>followcardList= adminFollowcardDao.getAllFollowcards();
        return followcardList;
    }

    @Override
    public boolean deleteFollowcard(int followcardId) {
        return adminFollowcardDao.deleteFollowcard(followcardId);
    }

    @Override
    public int batchDelete(List<Integer> followcardIds) {
        return adminFollowcardDao.batchDelete(followcardIds);
    }
}
