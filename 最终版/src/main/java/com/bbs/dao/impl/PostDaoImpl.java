package com.bbs.dao.impl;

import com.bbs.dao.PostDao;
import com.common.pojo.Post;
import com.common.pojo.User;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

     public User getUserById(Integer id){
        User user=currentSession().find(User.class,id);
        return user;
     }
    @Override
    public List<Post> getLatestPosts() {
        SQLQuery sqlQuery=this.currentSession().createSQLQuery("select * from post ORDER BY send_date DESC LIMIT 5");
        List<Post>listPosts=sqlQuery.addEntity(Post.class).list();
        return listPosts;
    }

    @Override
    public List<Map<String,Object>> getBestPosts(){
        Query query=currentSession().createSQLQuery("SELECT p.id,p.title,p.send_date,p.view_num,p.reply_num,s.title forum,s.id forumId FROM post p,sub_forum s WHERE p.sub_forum_id=s.id ORDER BY p.send_date DESC LIMIT 5");
        List<Object[]> allPosts = query.getResultList();
        List<Map<String,Object>>mapList=new ArrayList<>();
        for (Object[] obj:allPosts){
            Map<String,Object>map=new HashMap<>();
            map.put("id",obj[0]);
            map.put("title",obj[1]);
            map.put("sendDate",obj[2]);
            map.put("viewNum",obj[3]);
            map.put("replyNum",obj[4]);
            map.put("forum",obj[5]);
            map.put("forumId",obj[6]);
            mapList.add(map);
        }
        return mapList ;
    }

    @Override//7.10
    public List<Map<String,Object>> getBestPostsAll(){
        Query query=currentSession().createSQLQuery("SELECT p.id,p.title,p.send_date,p.view_num,p.reply_num,s.title forum,s.id forumId FROM post p,sub_forum s WHERE p.sub_forum_id=s.id ORDER BY p.send_date DESC");
        List<Object[]> allPosts = query.getResultList();
        List<Map<String,Object>>mapList=new ArrayList<>();
        for (Object[] obj:allPosts){
            Map<String,Object>map=new HashMap<>();
            map.put("id",obj[0]);
            map.put("title",obj[1]);
            map.put("sendDate",obj[2]);
            map.put("viewNum",obj[3]);
            map.put("replyNum",obj[4]);
            map.put("forum",obj[5]);
            map.put("forumId",obj[6]);
            mapList.add(map);
        }
        return mapList ;
    }

    @Override
    public List<Map<String,Object>> getPosts(){
        Query query=currentSession().createSQLQuery("SELECT b.id,p.title,p.send_date,p.view_num,p.reply_num,s.title forum,s.id forumId FROM post p,sub_forum s,best_post b WHERE p.sub_forum_id=s.id AND p.id=b.post_id ");
        List<Object[]> Posts = query.getResultList();
        List<Map<String,Object>>mapList=new ArrayList<>();
        for (Object[] obj:Posts){
            Map<String,Object>map=new HashMap<>();
            map.put("id",obj[0]);
            map.put("title",obj[1]);
            map.put("sendDate",obj[2]);
            map.put("viewNum",obj[3]);
            map.put("replyNum",obj[4]);
            map.put("forum",obj[5]);
            map.put("forumId",obj[6]);
            mapList.add(map);
        }
        return mapList ;
    }

    @Override//7.10
    public List<Map<String,Object>> getPostsAll(){
        Query query=currentSession().createSQLQuery("SELECT b.id,p.title,p.send_date,p.view_num,p.reply_num,s.title forum,s.id forumId FROM post p,sub_forum s,best_post b WHERE p.sub_forum_id=s.id AND p.id=b.post_id");
        List<Object[]> Posts = query.getResultList();
        List<Map<String,Object>>mapList=new ArrayList<>();
        for (Object[] obj:Posts){
            Map<String,Object>map=new HashMap<>();
            map.put("id",obj[0]);
            map.put("title",obj[1]);
            map.put("sendDate",obj[2]);
            map.put("viewNum",obj[3]);
            map.put("replyNum",obj[4]);
            map.put("forum",obj[5]);
            map.put("forumId",obj[6]);
            mapList.add(map);
        }
        return mapList ;
    }

    @Override
    public int save(Post post) {
        currentSession().save(post);
        return 0;
    }

    @Override
    public List<Map<String,Object>> maxPosts(){
        Query query=currentSession().createSQLQuery("SELECT p.id,p.title,p.send_date,p.view_num,p.reply_num,s.title forum,s.id forumId FROM post p,sub_forum s WHERE p.sub_forum_id=s.id ORDER BY view_num DESC");
        List<Object[]> Posts = query.getResultList();
        List<Map<String,Object>>mapList=new ArrayList<>();
        for (Object[] obj:Posts){
            Map<String,Object>map=new HashMap<>();
            map.put("id",obj[0]);
            map.put("title",obj[1]);
            map.put("sendDate",obj[2]);
            map.put("viewNum",obj[3]);
            map.put("replyNum",obj[4]);
            map.put("forum",obj[5]);
            map.put("forumId",obj[6]);
            mapList.add(map);
        }
        return mapList;
    }
}
