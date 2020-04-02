package com.admin.dao.impl;


import com.admin.dao.AdminMainForumDao;
import com.common.pojo.MainForum;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;


@Repository
@Transactional
public class AdminMainForumDaoImpl extends HibernateDaoSupport implements AdminMainForumDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

	@Override
	public List<MainForum> getAll() {
		List<MainForum> listUser= this.getHibernateTemplate().loadAll(MainForum.class);
		return listUser;
	}
}