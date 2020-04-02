package com.bbs.service.impl;
import com.bbs.service.NoticeService;
import com.bbs.dao.NoticeDao;
import com.common.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    @Override
    public List<Notice> getAll(){return noticeDao.getAll();}
    @Override
    public List<Map<String,Object>> getById(int id){return noticeDao.getById(id);}
    @Override
    public List<Notice> all(){return noticeDao.all();}
}
