package com.admin.dao.impl;

import com.admin.dao.AdminFollowcardDao;
import com.common.pojo.Followcard;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class AdminFollowcardDaoImpl extends HibernateDaoSupport implements AdminFollowcardDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Map<String,Object>> getAllFollowcards() {
        Query query=currentSession().createQuery("select f.followContent,f.followDate,u.username,f.id from Followcard f inner join User u on u.id=f.userId");
        List<Object []>objectList=query.getResultList();
        List<Map<String,Object>>mapList=new ArrayList<>();
        for (Object[] obj:objectList){
            Map<String,Object>map=new HashMap<>();
            map.put("followContent",obj[0]);
            map.put("followDate",obj[1]);
            map.put("username",obj[2]);
            map.put("id",obj[3]);
            mapList.add(map);
        }
        return mapList;
    }

    @Override
    public boolean deleteFollowcard(int followcardId) {
        Followcard followcard=new Followcard();
        followcard.setId(followcardId);
        try {
            currentSession().delete(followcard);
            Query query= currentSession().createQuery("delete from Followcard where id=?1");
            query.setParameter(1,followcardId);
            query.executeUpdate();
            System.out.println("================================");
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public int batchDelete(List<Integer> followcardIds) {
        Query query=currentSession().createQuery("delete from Followcard where id in ?1");
        query.setParameter(1,followcardIds);
        try {
            query.executeUpdate();
            return 200;
        }catch (Exception e){
            System.out.println(e.toString());
            return 400;
        }
    }
}
