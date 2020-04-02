package com.admin.service;

import com.common.pojo.Post;

import java.util.List;

public interface AdminPostService {
  //  List<Post> getLatestPosts();
    public List<Post> getAllPosts();

    //后台=============
    public boolean deletePost(int postId);

    public int batchDelete(List<Integer>postIds);
}
