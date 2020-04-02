package com.bbs.controller;

import com.bbs.dao.impl.PostAndFollowDaoImpl;
import com.bbs.service.FollowService;
import com.common.pojo.Followcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;

@Controller
@RequestMapping("/follow")
public class FollowController {
    @Autowired
    FollowService followService;
    @Autowired
    PostAndFollowDaoImpl postAndFollowDaoImpl;
    @RequestMapping("/submitFollow")
    public String submitFollow(Followcard followcard){
        followcard.setFollowDate(new Timestamp(System.currentTimeMillis()));
        followService.submitFollow(followcard);
        int i= postAndFollowDaoImpl.updateReplyById(followcard.getPostId());
        return "redirect:/postAndFollow/findByPost_Id.action?id="+followcard.getPostId();
    }
}
