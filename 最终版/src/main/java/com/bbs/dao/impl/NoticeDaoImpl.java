package com.bbs.dao.impl;

import com.bbs.dao.NoticeDao;
import javax.annotation.Resource;

import com.common.pojo.Notice;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@Repository
@Transactional
public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Notice> getAll(){
        SQLQuery sqlQuery=this.currentSession().createSQLQuery("select * from notice ORDER BY notice_date DESC LIMIT 4");
        List<Notice>listNotices=sqlQuery.addEntity(Notice.class).list();
        return listNotices;
    }
    @Override//根据ID查看公告主要内容
    public List<Map<String,Object>> getById(int id){
        Query query=currentSession().createSQLQuery("SELECT content,notice_date,title,id FROM notice WHERE id=?1");
        query.setInteger(1,id);
        List<Object[]> notices=query.getResultList();
        List<Map<String,Object>> noticeById=new ArrayList<>();
        for (Object[] obj:notices){
            Map<String,Object>map=new HashMap<>();
            map.put("content",obj[0]);
            map.put("noticeDate",obj[1]);
            map.put("title",obj[2]);
            map.put("id",obj[3]);
            noticeById.add(map);
        }
        return noticeById;
    }
    @Override//所有公告7.10
    public List<Notice> all(){
        SQLQuery sqlQuery=currentSession().createSQLQuery("select * from notice ORDER BY notice_date");
        List<Notice>listNotices=sqlQuery.addEntity(Notice.class).list();
        return listNotices;
    }
}
