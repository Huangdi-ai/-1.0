package com.admin.dao;

import com.common.pojo.Notice;

import java.util.List;

public interface AdminNoticeDao {
    public List<Notice> getAllNotices();

    public boolean deleteNotice(int noticeId);

    public Integer batchDelete(List<Integer>noticeIds);
    public  boolean  updateNotice(Notice notice);
    public boolean save(Notice notice);
    public  Notice getNoticeById(Integer id);
}
