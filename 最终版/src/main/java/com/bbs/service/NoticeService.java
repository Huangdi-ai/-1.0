package com.bbs.service;

import com.common.pojo.Notice;
import java.util.Map;
import java.util.List;
public interface NoticeService {
    List<Notice> getAll();
    List<Map<String,Object>> getById(int id);
    List<Notice> all();
}
