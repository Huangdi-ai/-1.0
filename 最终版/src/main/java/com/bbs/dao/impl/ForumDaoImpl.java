package com.bbs.dao.impl;

import com.bbs.dao.ForumDao;
import javax.annotation.Resource;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class ForumDaoImpl extends HibernateDaoSupport implements ForumDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Map<String,Object>> getForumById(int id){
        Query query=currentSession().createSQLQuery("SELECT s.title forum,s.id forumId, p.id,p.title,p.send_date,p.view_num,p.reply_num FROM post p,sub_forum s WHERE p.sub_forum_id=s.id AND s.id=?1");
        query.setInteger(1,id);
        List<Object[]> forum=query.getResultList();

        List<Map<String,Object>>listPosts=new ArrayList<>();

        for (Object[] obj:forum){
            Map<String,Object>map=new HashMap<>();
            map.put("forum",obj[0]);
            map.put("forumId",obj[1]);
            map.put("id",obj[2]);
            map.put("title",obj[3]);
            map.put("sendDate",obj[4]);
            map.put("viewNum",obj[5]);
            map.put("replyNum",obj[6]);
            listPosts.add(map);
        }
        return listPosts;
    }
    @Override
    public List<Map<String,Object>> getMainForumById(int id){
        Query query=currentSession().createSQLQuery("SELECT s.title forum, p.id,p.title,p.send_date,p.view_num,p.reply_num FROM post p,sub_forum s WHERE p.sub_forum_id=s.id AND s.main_forum_id=?1");
        query.setInteger(1,id);
        List<Object[]> forum=query.getResultList();

        List<Map<String,Object>>listPosts=new ArrayList<>();

        for (Object[] obj:forum){
            Map<String,Object>map=new HashMap<>();
            map.put("forum",obj[0]);
            map.put("id",obj[1]);
            map.put("title",obj[2]);
            map.put("sendDate",obj[3]);
            map.put("viewNum",obj[4]);
            map.put("replyNum",obj[5]);
            listPosts.add(map);
        }
        return listPosts;
    }

}