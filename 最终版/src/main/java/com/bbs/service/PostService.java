package com.bbs.service;

import com.common.pojo.Post;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<Post> getLatestPosts();
    List<Map<String,Object>> getBestPosts() throws JsonProcessingException;
    List<Map<String,Object>> getPosts();
    List<Map<String,Object>> maxPosts();
    List<Map<String,Object>> getBestPostsAll();
    List<Map<String,Object>> getPostsAll();
    int save(Post post);
}
