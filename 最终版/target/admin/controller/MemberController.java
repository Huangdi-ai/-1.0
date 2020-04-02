package com.admin.controller;



import com.admin.service.MemberService;

import com.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @RequestMapping("/getAllMember")
    public String Allusers(ModelMap modelMap) {
        modelMap.put("userLists", memberService.getUser());
        List<User>userList= memberService.getUser();
        return "admin/member-list";
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public String deleteById(int id) {
        memberService.deleteUser(id);
        return "200";
    }
    @RequestMapping("/batchDelete")
    @ResponseBody
    public int batchDelete(@RequestParam("userIds[]") Integer[] userIds) {
        List<Integer> userIdList = Arrays.asList(userIds);
        Integer num = memberService.batchDelete(userIdList);
        if (num.equals(200)) {
            return 200;
        } else {
            return 400;
        }
    }
    @RequestMapping("/blackUser")
    @ResponseBody
    public int blackUser(int id) {
        memberService.blackUser(id);
        return 200;
    }
}

