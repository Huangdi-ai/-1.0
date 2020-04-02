package com.bbs.service.impl;

import com.bbs.dao.PostDao;
import com.bbs.service.PostService;
import com.common.pojo.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    @Override
    public List<Post> getLatestPosts() {
        return postDao.getLatestPosts();
    }

    @Override

    public List<Map<String,Object>> getBestPosts() throws JsonProcessingException { return postDao.getBestPosts();}
    public List<Map<String,Object>> getPosts(){return postDao.getPosts();}

    @Override
    public int save(Post post) {
        return postDao.save(post);
    }
    public List<Map<String,Object>> maxPosts(){return postDao.maxPosts();}
    @Override
    public List<Map<String,Object>> getBestPostsAll(){return postDao.getBestPostsAll();}
    @Override
    public List<Map<String,Object>> getPostsAll(){return postDao.getPostsAll();}
}
