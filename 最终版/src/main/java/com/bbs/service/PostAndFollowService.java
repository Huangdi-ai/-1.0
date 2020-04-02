package com.bbs.service;

import com.common.pojo.Followcard;

import java.util.Map;
import java.util.List;

public interface PostAndFollowService {
    public Map<String,Object> findByPost_Id(int user_id);
    public void submitFollow(Followcard followcard);
    public List<Map<String,Object>> findByForum_Id(int forum_id);
    public int updateById(int id);
    public int updateReplyById(int id);
}
