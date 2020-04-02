package com.bbs.controller;


import com.bbs.dao.impl.PostDaoImpl;
import com.bbs.dao.impl.NoticeDaoImpl;
import com.bbs.service.MainForumService;
import com.common.pojo.SubForum;
import com.common.pojo.Notice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class IndexController {
    @Autowired
    PostDaoImpl postDaoImpl;
    @Autowired
    NoticeDaoImpl noticeDaoImpl;
    @Autowired
    MainForumService mainForumService;
    @RequestMapping("/test")
    public String hi(){
        return "bbs/postAndFollow/test";
    }
    @RequestMapping("/index")
    public String index(HttpSession session,ModelMap map)
    {
        List<Map<String,Object>> latestPosts=postDaoImpl.getBestPosts();
        map.put("latestPosts",latestPosts);
        List<Notice> notices=noticeDaoImpl.getAll();
        map.put("notices",notices);
        List<Map<String,Object>> bestPosts = postDaoImpl.getPosts();
        map.put("bestPosts",bestPosts);
        List<SubForum> mainforumSort = mainForumService.getAll();//fcl 7.10
        map.put("mainforumList",mainforumSort);
        return "bbs/index";
    }
}
