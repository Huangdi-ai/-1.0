package com.bbs.dao;

import java.util.List;
import java.util.Map;

public interface ForumDao {
    public List<Map<String,Object>> getForumById(int id);
    public List<Map<String,Object>> getMainForumById(int id);
}
