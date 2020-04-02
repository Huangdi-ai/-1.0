package com.admin.dao.impl;

import com.admin.dao.AdminPostDao;
import com.common.pojo.Post;

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
public class AdminPostDaoImpl extends HibernateDaoSupport implements AdminPostDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
    //后台==============
    @Override
    public List<Post> getAllPosts() {
        List<Post>postList=this.getHibernateTemplate().loadAll(Post.class);
        return postList;
    }

    @Override
    public boolean deletePost(int postId) {
        Post post=new Post();
        post.setId(postId);
        try {
          currentSession().delete(post);
           Query query= currentSession().createQuery("delete from Followcard where postId=?1");
           query.setParameter(1,postId);
            query.executeUpdate();
            System.out.println("================================");
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public int batchDelete(List<Integer> postIds) {
        Query query=currentSession().createQuery("delete from Post where id in ?1");
        query.setParameter(1,postIds);
        try {
            query.executeUpdate();
            return 200;
        }catch (Exception e){
            System.out.println(e.toString());
            return 400;
        }
    }

    public void save(){
        Post post=new Post();
        post.setCardContent("sdf");
        post.setReplyNum(34);
        post.setSendDate(new Timestamp(new java.util.Date().getTime()));
        currentSession().save(post);
    }

}
