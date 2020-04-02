package com.admin.service.impl;

import com.admin.dao.AdminPostDao;
import com.common.pojo.Post;
import com.admin.service.AdminPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminPostServiceImpl implements AdminPostService {
    @Autowired
    AdminPostDao adminPostDao;

  /*  @Override
    public List<Post> getLatestPosts() {
        return adminPostDao.getLatestPosts();
    }*/

    @Override
    public List<Post> getAllPosts() {
        return adminPostDao.getAllPosts();
    }

    @Override
    public boolean deletePost(int postId) {
        return adminPostDao.deletePost(postId);
    }


    public int batchDelete(List<Integer>postIds){
        return adminPostDao.batchDelete(postIds);
    }
}
