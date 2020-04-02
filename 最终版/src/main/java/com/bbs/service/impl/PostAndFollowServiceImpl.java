package com.bbs.service.impl;

import com.bbs.service.PostAndFollowService;
import com.common.pojo.Followcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbs.dao.PostAndFollowDao;
import java.util.Map;
import java.util.List;

@Service
public class PostAndFollowServiceImpl implements PostAndFollowService {
    @Autowired
    PostAndFollowDao postAndFollowDao;
    @Override
    public Map<String, Object> findByPost_Id(int user_id) {
        return postAndFollowDao.findByPost_Id(user_id);
    }

    @Override
    public void submitFollow(Followcard followcard) {
         postAndFollowDao.submitFollow(followcard);
    }

    @Override
    public List<Map<String,Object>> findByForum_Id(int forum_id){return postAndFollowDao.findByForum_Id(forum_id);}
    @Override
    public int updateById(int id){return postAndFollowDao.updateById(id);}
    @Override
    public int updateReplyById(int id){return postAndFollowDao.updateReplyById(id);}
}
