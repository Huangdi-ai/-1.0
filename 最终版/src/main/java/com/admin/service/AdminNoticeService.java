package com.admin.service;

import com.common.pojo.Notice;

import java.util.List;

public interface AdminNoticeService {
    public List<Notice> getAllNotices();

    //后台=============
    public boolean deleteNotice(int noticeId);

    public    Integer batchDelete(List<Integer>noticeIds);
    public    boolean updateNotice(Notice notice);
    public    boolean save(Notice notice);
    public    Notice getNoticeById(Integer id);
}
