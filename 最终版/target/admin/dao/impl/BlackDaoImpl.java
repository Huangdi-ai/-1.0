package com.admin.dao.impl;

import com.admin.dao.BlackDao;

import com.common.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlackDaoImpl extends HibernateDaoSupport implements BlackDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<User> getBlack() {
        Query query= currentSession().createQuery("from User where hasActive=0");
        List<User>userList = query.getResultList();
        System.out.println("================================");
        return userList;
    }
  
    @Override
    public boolean recover(int id) {
        User user=new User();
        user.setId(id);
        try {
            Query query= currentSession().createQuery("update User set hasActive=1 where id=?1");
            query.setParameter(1,id);
            query.executeUpdate();
            System.out.println("================================");
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
}
