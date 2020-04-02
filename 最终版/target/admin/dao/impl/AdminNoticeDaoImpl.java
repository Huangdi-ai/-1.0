package com.admin.dao.impl;

import com.admin.dao.AdminNoticeDao;

import com.common.pojo.Notice;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;


@Repository
@Transactional
public class AdminNoticeDaoImpl  extends HibernateDaoSupport implements AdminNoticeDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public List<Notice> getAllNotices() {
        List<Notice> noticeList = this.getHibernateTemplate().loadAll(Notice.class);
        return noticeList;
    }


    @Override
    public boolean deleteNotice(int noticeId) {
        Notice notice = new Notice();
        notice.setId(noticeId);
        try {
            currentSession().delete(notice);
            Query query = currentSession().createQuery("delete from Notice where id=?1");
            query.setParameter(1,noticeId);
            query.executeUpdate();
            System.out.println("================================");
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public Integer batchDelete(List<Integer> noticeIds) {
        Query query = currentSession().createQuery("delete from Notice where id in ?1");
        query.setParameter(1, noticeIds);
        try {
            query.executeUpdate();
            return 200;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 400;
        }
    }

    @Override
    public boolean save(Notice notice) {
        try {
            notice.setNoticeDate(new Timestamp(new java.util.Date().getTime()));
            currentSession().save(notice);
            return true;
        }catch (Exception e) {
                System.out.println(e.toString());
                return false;
            }
    }

    @Override
    public Notice getNoticeById(Integer id) {
        Notice notice=currentSession().find(Notice.class,id);
        return notice;
    }


    @Override
    public boolean updateNotice(Notice notice) {
        try {
            notice.setNoticeDate(new Timestamp(new java.util.Date().getTime()));
            currentSession().update(notice);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
