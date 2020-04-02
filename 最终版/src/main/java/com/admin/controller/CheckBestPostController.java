package com.admin.controller;

import com.admin.dao.CheckBestPostDao;
import com.common.pojo.BestPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CheckBestPostController {
    @Autowired
    CheckBestPostDao checkBestPostDao;

    @RequestMapping("/checkBestPostApply")
    public String checkBestPostApply(ModelMap modelMap)
    {
        modelMap.put("bestList",checkBestPostDao.checkBestPostApply());
        return "admin/checkBestPost";
    }

    @RequestMapping("/saveBestPost")
    public String saveBestPost(BestPost bestPost){
        bestPost.setApplyDate(new Timestamp(System.currentTimeMillis()));
        bestPost.setState(0);
        checkBestPostDao.saveBestPost(bestPost);
        return "redirect:/admin/getApplyRecord.action?id="+bestPost.getUserId();
    }
    //通过
    @RequestMapping("/applyok")
    public int applyok(int id) {
        checkBestPostDao.applyok(id);
        return 200;
    }
    //拒绝
    //通过
    @RequestMapping("/applydeny")
    public int applydeny(int id) {
        checkBestPostDao.applydeny(id);
        return 200;
    }

    //前台我要查看我的申请记录：
    @RequestMapping("/getApplyRecord")
    public String getApplyRecord(Integer id, ModelMap modelMap){
        List<BestPost>bestPostList=checkBestPostDao.getApplyRecord(id);
        modelMap.put("bestPostList",bestPostList);
        return "bbs/postAndFollow/applyRecord";
    }
}
