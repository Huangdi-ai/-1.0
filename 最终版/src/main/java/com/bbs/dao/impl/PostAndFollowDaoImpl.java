package com.bbs.dao.impl;

import com.bbs.dao.PostAndFollowDao;
import com.common.pojo.Followcard;
import com.common.pojo.Post;
import com.common.pojo.SubForum;
import com.common.pojo.User;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
@Transactional
public class PostAndFollowDaoImpl extends HibernateDaoSupport implements PostAndFollowDao {
    @Resource
    public void setSessionFactory0(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public Map<String,Object> findByPost_Id(int post_id) {
        Post post=currentSession().find(Post.class,post_id);  //post和user
       // List<SubForum> subForum=post.getSubForumList();
        SubForum subForum=post.getSubForum();
        //String d=subForum.getTitle();
//        for (SubForum s:subForum){
//            System.out.println(s.getTitle());
//        }
      //  System.out.println(subForum);
        User user=post.getUser();
        //#############################
        Map<String,Object>map=new HashMap<>();
        map.put("user",user);
        map.put("post",post);
        Map<String, Object> map2 = new HashMap<>();
        try {
            List<Followcard> followList = (List<Followcard>) post.getFollowcardSet();//post和follow一对多（里面包含了folw和user的一对一）
            //System.out.println(followList.get(0).getUser().getUsername());
            map2.put("followcardList", followList);
        }catch (Exception e){System.out.println(e.toString());}
        finally {
            map2.put("mainPost", map);
            map2.put("subMainForum",subForum);
            return map2;
        }
    }

    @Override
    public List<Map<String,Object>> findByForum_Id(int forum_id){
        Query query=currentSession().createSQLQuery("SELECT m.title forum,p.title,p.id,p.reply_num,p.send_date,p.view_num FROM main_forum m,post p WHERE p.post_type=m.id AND m.id=?1");
        query.setInteger(1,forum_id);
        List<Object[]> posts=query.getResultList();
        List<Map<String,Object>> postbyforum=new ArrayList<>();
        for (Object[] obj:posts){
            Map<String,Object>map=new HashMap<>();
            map.put("forum",obj[0]);
            map.put("title",obj[1]);
            map.put("id",obj[2]);
            map.put("replyNum",obj[3]);
            map.put("sendDate",obj[4]);
            map.put("viewNum",obj[5]);
            postbyforum.add(map);
        }
        return postbyforum;
    }

    @Override//fcl 7.10 浏览量
    public int updateById(int id){
        try {
            int inse = currentSession().createSQLQuery("UPDATE post SET view_num=view_num+1 WHERE id=?1").setInteger(1, id).executeUpdate();
            return inse;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return 0;
    }
    @Override//fcl7.10回帖数目
    public int updateReplyById(int id){
        try{
            int inse = currentSession().createSQLQuery("UPDATE post SET reply_num=reply_num+1 WHERE id=?1").setInteger(1, id).executeUpdate();
            return inse;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return 0;
    }

    /**
     * 发表评论
     */
    @Override
    public void submitFollow(Followcard followcard) {
        currentSession().save(followcard);
        }
}
