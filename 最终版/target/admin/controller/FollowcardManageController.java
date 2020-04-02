package com.admin.controller;

import com.admin.service.AdminFollowcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/followcard")
public class FollowcardManageController {
    @Autowired
    AdminFollowcardService adminFollowcardService;

    @RequestMapping("/index")

    public String index(ModelMap modelMap) {
        modelMap.put("followcardLists", adminFollowcardService.getAllFollowcards());
        return "admin/feedback-list";
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(int id) {
        adminFollowcardService.deleteFollowcard(id);
        return "200";
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public int batchDelete(@RequestParam("userIds[]") Integer[] userIds) {
        List<Integer> userIdList = Arrays.asList(userIds);
        Integer num = adminFollowcardService.batchDelete(userIdList);
        if (num.equals(200)) {
            return 200;
        } else {
            return 400;
        }
    }

}
