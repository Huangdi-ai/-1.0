package com.bbs.service.impl;
import com.bbs.dao.ForumDao;
import com.bbs.service.ForumService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired ForumDao forumDao;
    public List<Map<String,Object>> getForumById(int id){
        return forumDao.getForumById(id);
    }
    public List<Map<String,Object>> getMainForumById(int id){return forumDao.getMainForumById(id);}
}
