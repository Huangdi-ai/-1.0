package com.admin.controller;

import com.admin.service.ModuleService;

import com.common.pojo.SubForum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/Forum")
public class ModuleConteoller {
    @Autowired
    ModuleService moduleService;
    @RequestMapping("/getForum")

    public String index(ModelMap modelMap) {
        modelMap.put("subforumList", moduleService.getForum());
      return "admin/Forum";

    }

    @RequestMapping("/showUpdate")
        public String showUpdate(Integer id,ModelMap modelMap){
            SubForum forum = moduleService.getForumById(id);
            modelMap.put("forum",forum);
            return "admin/Forum-update";
        }
    @RequestMapping("/Save")
        public String save(SubForum subForum, ModelMap modelMap){
            boolean a=moduleService.save(subForum);
            modelMap.put("status",a);
            return "redirect:/admin/Forum/getForum.action";
        }
    @RequestMapping("updateSubForum")
    //@ResponseBody
    public String updateForum(SubForum subForum ){
        boolean a=moduleService.updateSubForum(subForum);
        //modelMap.put("status",a);
        // return String.valueOf(a);
        // adminNoticeService.updateNotice(notice);
        return "redirect:/admin/Forum/getForum.action";
    }

        @RequestMapping("/batchDelete")
        @ResponseBody
        public Integer batchDelete(@RequestParam("userIds[]") Integer[] userIds) {
            List<Integer> userIdList = Arrays.asList(userIds);
            Integer num = moduleService.batchDelete(userIdList);
            if (num.equals(200)) {
                return 200;
            } else {
                return 400;
            }
        }
        @RequestMapping("/deleteById")
        @ResponseBody
        public String deleteById(int id) {
            moduleService.deleteSubForum(id);
            return "200";
        }
    @RequestMapping("/showAdd")
    public String showAdd(){
        return "admin/Forum-add";
    }
    }

