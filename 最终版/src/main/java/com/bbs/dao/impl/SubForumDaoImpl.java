package com.bbs.dao.impl;

import com.bbs.dao.SubForumDao;
import com.common.pojo.SubForum;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
@Repository
@Transactional
public class SubForumDaoImpl extends HibernateDaoSupport implements SubForumDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<SubForum> getAllSubForum() {
        List<SubForum> listSubForumDao = this.getHibernateTemplate().loadAll(SubForum.class);
        return listSubForumDao;
    }
}
