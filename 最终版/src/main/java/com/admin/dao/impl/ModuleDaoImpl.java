package com.admin.dao.impl;


import com.admin.dao.ModuleDao;
import com.common.pojo.SubForum;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
public class ModuleDaoImpl extends HibernateDaoSupport implements ModuleDao{
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    @Override
    public List<SubForum> getForum() {
        List<SubForum>subforumList=this.getHibernateTemplate().loadAll(SubForum.class);
        return subforumList;
    }
    @Override
    public boolean deleteSubForum(int id) {
        SubForum subForum = new SubForum();
        subForum.setId(id);
        try {
            currentSession().delete(subForum);
            Query query = currentSession().createQuery("delete from SubForum where id=?1");
            query.setParameter(1,id);
            query.executeUpdate();
            System.out.println("================================");
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public Integer batchDelete(List<Integer> id) {
        Query query = currentSession().createQuery("delete from SubForum where id in ?1");
        query.setParameter(1, id);
        try {
            query.executeUpdate();
            return 200;
        } catch (Exception e) {
            System.out.println(e.toString());
            return 400;
        }
    }

    @Override
    public boolean save(SubForum subForum) {
        try {
            //subForum.setSubfourmDate(new Timestamp(new java.util.Date().getTime()));
            currentSession().save(subForum);
            return true;
        }catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public SubForum getFourmById(Integer id) {
        SubForum subForum=currentSession().find(SubForum.class,id);
        return subForum;
    }


    @Override
    public boolean updateSubforum(SubForum subForum) {
        try {
           // subForum.setSubFourmDate(new Timestamp(new java.util.Date().getTime()));
            currentSession().merge(subForum);
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
