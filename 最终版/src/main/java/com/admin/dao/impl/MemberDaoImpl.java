package com.admin.dao.impl;


import com.admin.dao.MemberDao;

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
public class MemberDaoImpl extends HibernateDaoSupport implements MemberDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<User> getUser() {
      Query query= currentSession().createQuery("from User where hasActive=1");
        List<User>userList= query.getResultList();
        System.out.println("================================");
        return userList;
    }
    @Override
    public boolean deleteUser(int userId) {
        User user=new User();
        user.setId(userId);
        try {
            currentSession().delete(user);
            Query query= currentSession().createQuery("delete from User where id=?1");
            query.setParameter(1,userId);
            query.executeUpdate();
            System.out.println("================================");
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public int batchDelete(List<Integer> userIds) {
        Query query=currentSession().createQuery("delete from User where id in ?1");
        query.setParameter(1,userIds);
        try {
            query.executeUpdate();
            return 200;
        }catch (Exception e){
            System.out.println(e.toString());
            return 400;
        }
    }
    @Override
    public boolean blackUser(int id){
        User user=new User();
        user.setId(id);
        try {
            Query query= currentSession().createQuery("update User set hasActive=0 where id=?1");
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
