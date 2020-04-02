package com.bbs.dao;

import com.common.pojo.Notice;
import java.util.Map;
import java.util.List;

public interface NoticeDao {
    List<Notice> getAll();
    List<Map<String,Object>> getById(int id);
    List<Notice> all();
}
