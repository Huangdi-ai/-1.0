package com.bbs.dao.impl;
import com.common.pojo.Post;
import com.common.pojo.User;
import org.hibernate.Query;
import com.bbs.dao.UserDao;

import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Repository
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao  {

    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
    private static final Logger log = LoggerFactory.getLogger(UserDao.class);
    // property constants
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PHOTO_URL = "photoUrl";
    public static final String EMAIL = "email";
    public static final String TYPE = "type";
    public static final String SIGNATURE = "signature";
    public static final String LEVEL = "level";
    public static final String ACTIVE_CODE = "activeCode";
    public static final String HAS_ACTIVE = "hasActive";



   public User findByProperty(String propertyName, Object value) {
        try {
            List list=getSessionFactory().getCurrentSession().createQuery("from User as model where model."

                    + propertyName + "="+value).list();


            return (User) list;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

   public List<User> findByUsername(String username) {

       javax.persistence.Query query=getSessionFactory().getCurrentSession().createQuery("from User where username=?1");
       query.setParameter(1,username);
       List<User>user=  query.getResultList();

       return user;
    }
    public List findByPassword(Object password) {
        return (List) findByProperty(PASSWORD, password);
    }
    public List findByPhotoUrl(Object photoUrl) {
        return (List) findByProperty(PHOTO_URL, photoUrl);
    }
   public List<User> findByEmail(String email) {
       javax.persistence.Query query=getSessionFactory().getCurrentSession().createQuery("from User where email=?1");
       query.setParameter(1,email);
       List<User>user=  query.getResultList();
       return user;
   }


    public List findByActiveCode(Object activeCode) {
        return (List) findByProperty(ACTIVE_CODE, activeCode);
    }

    public List findByHasActive(Object hasActive) {
        return (List) findByProperty(HAS_ACTIVE, hasActive);
    }
  //  @Override
    public boolean regist(User user) {//HibernateSessionFactory.getSession();
        Session session = getSessionFactory().getCurrentSession();
        System.out.println(user);
        session.save(user);
        //session.close();
        //Transaction trans=session.beginTransaction();
      //  session.update(user);
        //trans.commit();
        /*String sql="insert into user(username,password,email) value(?0,?0,?0)";
        Query query=session.createSQLQuery(sql);
        query.setParameter(1,user.getUsername());
        query.setParameter(2,user.getPassword());
        query.setParameter(3,user.getEmail());*/
        //trans.commit();

        return true;
    }

   @Override
    public int login(String username ,String password) {
       List<User>user=findByUsername(username);
       if(user != null && user.size() > 0) {
           if (user.get(0).getPassword().equals(password))
               return user.get(0).getId();
           return -1;
       }
       else return 0;
       //return findByUsername(username);
    }

    @Override
    public boolean changePassword(int userId, int oldpasswod, int newpassword) {
            return false;
    }

    @Override
    public void update(User user) {

        currentSession().merge(user);
    }

    @Override
    public User getUserById(Integer integer) {
       User user=currentSession().find(User.class,integer);
        return  user;
    }

    private User findById(Integer id) {
        log.debug("getting User instance with id: " + id);
        try {
            Session session = getSessionFactory().getCurrentSession();
            User instance = (User) session.get("com.bbs.model.User", id);

            session.close();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    @Override
    public int getUserIdByUsername(String username) {
        List<User>users = findByUsername(username);
        if (users != null && users.size()>0)
            return users.get(0).getId();
        return -1;
    }

    @Override
    public int activeUser(String activeCode) {
        List<User> uses = findByActiveCode(activeCode);
        if (uses != null && uses.size()>0){
            User user = uses.get(0);
            if (user.getHasActive() == 0){
                user.setHasActive(1);
                Session session = getSessionFactory().getCurrentSession();
                Transaction transaction = session.beginTransaction();
                session.update(user);
                session.close();
                return 1;
            }else {
                return -1;
            }

        }
        return 0;
    }

    @Override
    public void updateCode(String username, String code) {

    }

    //@Override
    public int isExist(User user) {
        if (findByUsername(user.getUsername()).size()>0)
            return 1;
        else if (findByEmail(user.getEmail()).size()>0)
            return 2;
        return -1;
    }
    @Override
    public int getUserByEmail(String email) {
        List<User>users = findByEmail(email);
        if (users != null && users.size()>0)

            return users.get(0).getId();
        return -1;
    }

    @Override
    public List<Post> getUserPost(int userId) {
        javax.persistence.Query query=currentSession().createQuery("from Post where userId=?1");
        query.setParameter(1,userId);
        List<Post> postList=query.getResultList();
        return postList;
    }
    @Override
    public int saveUpdate(User user){
       currentSession().merge(user);
       //currentSession().find(User.class,user.getId());
       return 200;
    }

}
