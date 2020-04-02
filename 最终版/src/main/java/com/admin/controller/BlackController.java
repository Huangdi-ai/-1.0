package com.admin.controller;

import com.admin.service.BlackService;


import com.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/admin/black")
public class BlackController {
    @Autowired
    BlackService blackService;
   @RequestMapping("/blackUser")
   //@ResponseBody
   // public List<BlackList> black(ModelMap modelMap) {
       public String black (ModelMap modelMap){
           modelMap.put("userLists", blackService.getBlack());
           List<User> userList = blackService.getBlack();
           return "admin/blackUser";
       }
   @RequestMapping("/recover")
   @ResponseBody
    public Integer recover(Integer id) {
       blackService.recover(id);
        //List<BlackList>blackList= blackService.getBlack();
        //    return blackList;
        return 200;
    }
}
