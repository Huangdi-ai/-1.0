package com.admin.dao;

import com.common.pojo.Post;

import java.util.List;

public interface AdminPostDao {
   // List<Post> getLatestPosts();

    //后台====================
    public List<Post> getAllPosts();

    public boolean deletePost(int postId);

    public int batchDelete(List<Integer>postIds);

    public void save();
}
