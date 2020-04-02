package com.bbs.dao.impl;

import com.admin.dao.AdminFollowcardDao;
import com.bbs.dao.FollowDao;
import com.bbs.dao.ForumDao;
import com.common.pojo.Followcard;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

    @Repository
    @Transactional
    public class FollowDaoImpl extends HibernateDaoSupport implements FollowDao {
        @Resource
        public void setSessionFactory0(SessionFactory sessionFactory){
            super.setSessionFactory(sessionFactory);
        }

    @Override
    public int submitFollow(Followcard followcard) {
        currentSession().save(followcard);
        return 200;
    }
    }
