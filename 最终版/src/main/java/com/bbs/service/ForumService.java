package com.bbs.service;
import com.common.pojo.SubForum;
import java.util.List;
import java.util.Map;

public interface ForumService {
    public List<Map<String,Object>> getForumById(int id);
    public List<Map<String,Object>> getMainForumById(int id);
}