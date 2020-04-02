package com.admin.controller;

import com.admin.service.AdminPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class PostManageController {
    @Autowired
    AdminPostService adminPostService;

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("postLists", adminPostService.getAllPosts());
        return "admin/post-list";
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(int id) {
        adminPostService.deletePost(id);
        return "200";
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public int batchDelete(@RequestParam("userIds[]") Integer[] userIds) {
        List<Integer> userIdList = Arrays.asList(userIds);
        Integer num = adminPostService.batchDelete(userIdList);
        if (num.equals(200)) {
            return 200;
        } else {
            return 400;
        }
    }
}
