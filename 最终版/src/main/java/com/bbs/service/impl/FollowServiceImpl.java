package com.bbs.service.impl;

import com.bbs.dao.FollowDao;
import com.bbs.service.FollowService;
import com.common.pojo.Followcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
@Service
public class FollowServiceImpl implements FollowService {
    @Autowired
    FollowDao followDao;
    @Override
    public int submitFollow(Followcard followcard) {
        return followDao.submitFollow(followcard);
    }
}
