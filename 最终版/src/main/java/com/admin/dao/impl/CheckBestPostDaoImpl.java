package com.admin.dao.impl;

import com.admin.dao.CheckBestPostDao;
import com.common.pojo.BestPost;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CheckBestPostDaoImpl extends HibernateDaoSupport implements CheckBestPostDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }


    @Override
    public int saveBestPost(BestPost bestPost) {
        currentSession().save(bestPost);
        return 200;
    }

    @Override
    public List<BestPost> getApplyRecord(Integer id) {

        Query query=currentSession().createQuery("FROM BestPost where userId=?1");
        query.setParameter(1,id);
        List<BestPost>bestPostList= query.getResultList();
       /* currentSession().find(BestPost.class,id)*/
        return bestPostList;
    }
    public List<BestPost> checkBestPostApply(){
        Query query=currentSession().createQuery("from BestPost where state=0");
        List<BestPost> bestPost=query.getResultList();
        return bestPost;
    }
    //通过
    @Override
    public Integer applyok(Integer id){
        BestPost bestPost=currentSession().find(BestPost.class,id);
        bestPost.setState(1);
        currentSession().merge(bestPost);
        return 200;
    }
    //不通过
    @Override
    public Integer applydeny(Integer id) {
        BestPost bestPost=currentSession().find(BestPost.class,id);
        bestPost.setState(2);
        currentSession().merge(bestPost);
        return 200;
    }
}
