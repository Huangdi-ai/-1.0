package com.bbs.controller;

import com.bbs.dao.impl.ForumDaoImpl;
import com.bbs.dao.impl.PostDaoImpl;
import com.bbs.dao.impl.NoticeDaoImpl;
import com.bbs.service.*;
import com.common.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/postAndFollow")
public class PostAndFollowController {
    @Autowired
    PostAndFollowService postAndFollowService;
    @Autowired
    SubForumService subForumService;
    @Autowired
    MainForumService mainForumService;
    @Autowired
    PostService postService;
    @Autowired
    ForumDaoImpl forumDaoImpl;
    @Autowired
    PostDaoImpl postDaoImpl;
    @Autowired
    NoticeDaoImpl noticeDaoImpl;
    @Autowired
    UserserService userserService;

    @Autowired
    PostDaoImpl getPostDaoImpl;
    /**
     * 发帖页面================================
     * @param map
     * @return
     */
    @RequestMapping("/getAllSubForum")
   // @ResponseBody
  //  public List<MainForum> getAllMainForum(ModelMap map){
    public String getAllSubForum(ModelMap map, HttpSession session){
        Integer userId= (Integer) session.getAttribute("userId");
        User user=getPostDaoImpl.getUserById(userId);
        if (user.getHasActive().equals(0)){
            return "redirect:/index.action";
        }
    /*
        User user=userserService.getUserById(userId);
        if (user.getHasActive()==0){
            return "redirect:/index.action";
        }
        if(session.getAttribute("username")==null){
            return "redirect:/loginjsp.action";
        }*/
       map.put("SubForumList",subForumService.getAllSubForum());
      //  List<MainForum> n=mainForumService.getAll();
    //    System.out.println( n.get(0).getSubForum().get(0).getId());
     //   return mainForumService.getAll();
      return "bbs/postAndFollow/publish_post";
    }

    @RequestMapping("/getAllMainForum")
    // @ResponseBody
    //  public List<MainForum> getAllMainForum(ModelMap map){
    public String getAllMainForum(ModelMap map){
        map.put("mainfourmAndSubList",mainForumService.getAll());
        List<SubForum> mainforumSort = mainForumService.getAll();
        map.put("mainforumList",mainforumSort);
        //  List<MainForum> n=mainForumService.getAll();

        //    System.out.println( n.get(0).getSubForum().get(0).getId());
        //   return mainForumService.getAll();
        return "bbs/postAndFollow/publish_post";
    }

    @RequestMapping("/findByForumId")//fcl 7.10
    public String findByForun_Id(int forum_id,String forum_title,ModelMap modelMap){
        List<Map<String,Object>> forums = forumDaoImpl.getForumById(forum_id);
        modelMap.put("forums",forums);
        List<SubForum> mainforumSort = mainForumService.getAll();
        modelMap.put("mainforumList",mainforumSort);
        modelMap.put("forumTitle",forum_title);
        return "bbs/postAndFollow/forum";
    }

    @RequestMapping("/maxPosts")
    public String maxPosts(ModelMap modelMap){
        List<Map<String,Object>> posts = postDaoImpl.maxPosts();
        modelMap.put("posts",posts);
        List<SubForum> mainforumSort = mainForumService.getAll();
        modelMap.put("mainforumList",mainforumSort);
        return "bbs/postAndFollow/hotPost";
    }

    @RequestMapping("/latestPosts")
    public String latestPosts(ModelMap map){
        List<Map<String,Object>> latestPosts=postDaoImpl.getBestPostsAll();
        map.put("latestPosts",latestPosts);
        List<SubForum> mainforumSort = mainForumService.getAll();
        map.put("mainforumList",mainforumSort);
        return "bbs/postAndFollow/latestPosts";
    }

    @RequestMapping("/bestPosts")
    public String bestPosts(ModelMap map){
        List<Map<String,Object>> bestPosts = postDaoImpl.getPostsAll();
        map.put("bestPosts",bestPosts);
        List<SubForum> mainforumSort = mainForumService.getAll();
        map.put("mainforumList",mainforumSort);
        return "bbs/postAndFollow/bestPosts";
    }

    @RequestMapping("/noticeById")
    public String noticeById(int id, ModelMap map){
        List<Map<String,Object>> notice=noticeDaoImpl.getById(id);
        map.put("notice",notice);
        List<SubForum> mainforumSort = mainForumService.getAll();
        map.put("mainforumList",mainforumSort);
        return "bbs/postAndFollow/notice";
    }

    @RequestMapping("getAllNotice")
    public String getAll(ModelMap map){
        List<Notice> notices=noticeDaoImpl.all();
        map.put("notices",notices);
        List<SubForum> mainforumSort = mainForumService.getAll();
        map.put("mainforumList",mainforumSort);
        return "bbs/postAndFollow/allNotice";
    }

    @RequestMapping("/findByPost_Id")
   //@ResponseBody
    public  String findByPost_Id(int id,ModelMap modelMap) {
    //public  Map<String, Object> findByPost_Id(int user_id) {
        Map<String, Object> ok = postAndFollowService.findByPost_Id(id);
        modelMap.put("userPostFollow",ok);
        int i=postAndFollowService.updateById(id);
        //modelMap.put("userPostFollow",ok);
      //  return ok;
        return "bbs/postAndFollow/post";
    }
    @RequestMapping("/savePost")
    public String savePost(HttpServletRequest request){
        Post post=new Post();
        post.setUserId(Integer.valueOf(request.getParameter("userId")));
        post.setTitle(request.getParameter("title"));
        post.setCardContent(request.getParameter("content"));
        post.setSubForumId(Integer.valueOf(request.getParameter("sub")));
        post.setSendDate(new Date());
        post.setPostType(0);
        post.setViewNum(0);
        post.setReplyNum(0);
        postService.save(post);
        return "redirect:/index.action";
    }
    @RequestMapping("/getMainForumById")
    public String findMainForunId(int forum_id,ModelMap modelMap){
        List<Map<String,Object>> forums = forumDaoImpl.getMainForumById(forum_id);
        modelMap.put("forums",forums);
        List<SubForum> mainforumSort = mainForumService.getAll();
        modelMap.put("mainforumList",mainforumSort);
        return "bbs/postAndFollow/forum";
    }

}
