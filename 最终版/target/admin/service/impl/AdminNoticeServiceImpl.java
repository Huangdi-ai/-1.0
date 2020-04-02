package com.admin.service.impl;


import com.admin.dao.AdminNoticeDao;
import com.common.pojo.Notice;
import com.admin.service.AdminNoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminNoticeServiceImpl  implements AdminNoticeService{
    @Autowired
    AdminNoticeDao adminNoticeDao;


    @Override
    public List<Notice> getAllNotices() {
        return adminNoticeDao.getAllNotices();
    }

    @Override
    public boolean deleteNotice(int noticeId) {
        return adminNoticeDao.deleteNotice(noticeId);
    }


    public Integer batchDelete(List<Integer>noticeIds){
        return adminNoticeDao.batchDelete(noticeIds);
    }
    @Override
    public    boolean  updateNotice(Notice notice){
        return adminNoticeDao.updateNotice(notice);
    }

    @Override
    public    boolean  save(Notice notice){
        return adminNoticeDao.save(notice);
    }

    @Override
    public Notice getNoticeById(Integer id) {
        return adminNoticeDao. getNoticeById(id);

    }


}
