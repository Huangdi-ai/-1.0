package com.bbs.service.impl;

import com.bbs.dao.SubForumDao;
import com.bbs.service.MainForumService;
import com.bbs.service.SubForumService;
import com.common.pojo.MainForum;
import com.common.pojo.SubForum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubForumServiceImpl implements SubForumService {

    @Autowired
    SubForumDao subForumDao;

    @Override
    public List<SubForum> getAllSubForum() {
        return subForumDao.getAllSubForum();
    }
}
