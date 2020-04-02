package com.bbs.dao.impl;


import com.bbs.dao.MainForumDao;
import com.common.pojo.SubForum;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;


@Repository
@Transactional
public class MainForumDaoImpl extends HibernateDaoSupport implements MainForumDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

	@Override//fcl 7.10
	public List<SubForum> getAll() {
		List<SubForum> listUser= this.getHibernateTemplate().loadAll(SubForum.class);
		return listUser;
	}

}