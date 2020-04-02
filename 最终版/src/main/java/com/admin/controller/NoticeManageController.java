package com.admin.controller;


import com.admin.service.AdminNoticeService;
import com.common.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/notice")
public class NoticeManageController {
    @Autowired
    AdminNoticeService adminNoticeService;




    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("noticeLists", adminNoticeService.getAllNotices());
        return "admin/notice-list";
    }




    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(int id) {
        adminNoticeService.deleteNotice(id);
        return "200";
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public Integer batchDelete(@RequestParam("userIds[]") Integer[] userIds) {
        List<Integer> userIdList = Arrays.asList(userIds);
        Integer num = adminNoticeService.batchDelete(userIdList);
        if (num.equals(200)) {
            return 200;
        } else {
            return 400;
        }
    }

    @RequestMapping("/updateNotice")
    //@ResponseBody
    public String updateNotice(Notice notice ){
       boolean a=adminNoticeService.updateNotice(notice);
        //modelMap.put("status",a);
       // return String.valueOf(a);
       // adminNoticeService.updateNotice(notice);
     return "redirect:/admin/notice/index.action";
    }




    @RequestMapping("/save")
    //@ResponseBody
    public String save(Notice notice,ModelMap modelMap){
        boolean a=adminNoticeService.save(notice);
        modelMap.put("status",a);
        // return String.valueOf(a);
        return "redirect:/admin/notice/index.action";
    }

    @RequestMapping("/showAdd")
    public String showAdd(){
        return "admin/notice-add";
    }

   /* @RequestMapping("/updateNotice")
    public String updateNotice(Integer id,ModelMap modelMap) {
        Notice notice = adminNoticeService.getNoticeById(id);
        modelMap.put("notice", notice);
        return "redirect:/admin/notice/index.action";
    }*/
    @RequestMapping("/showUpdate")
    public String showUpdate(Integer id,ModelMap modelMap){
        Notice notice =adminNoticeService.getNoticeById(id);
        modelMap.put("notice",notice);
        return "admin/notice-update";
    }

}
