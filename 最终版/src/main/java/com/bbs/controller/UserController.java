package com.bbs.controller;

import com.bbs.dao.UserDao;
import com.bbs.service.MainForumService;
import com.bbs.service.UserserService;
import com.common.pojo.SubForum;
import com.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserserService userserService;
    @Autowired
    MainForumService mainForumService;
    @Autowired
    UserDao userDao;
    @RequestMapping("/mypost")
    public String getMyPost(int id, ModelMap modelMap){
        modelMap.put("UserPostsList",userserService.getUserPost(id));
        return "bbs/postAndFollow/mypost";
    }
    @RequestMapping("/userInfo")
    public String userInfo(Integer id,ModelMap modelMap){
        List<SubForum> mainforumSort = mainForumService.getAll();//fcl 7.10
        modelMap.put("mainforumList",mainforumSort);
        modelMap.put("userInfo",userserService.getUserById(id));
        return "bbs/userInfo";
    }
    @RequestMapping(value = "/saveUpdate",method = RequestMethod.POST)
   // public String saveUpdate(User user, ModelMap modelMap, MultipartFile file, HttpServletRequest request) throws IOException {
    public String saveUpdate(User user,@RequestParam MultipartFile uploadFile,HttpServletRequest request) throws IOException {
        String name=String.valueOf(UUID.randomUUID());
        String newFileName = name + ".jpg";
       //System.out.println(request.getServletContext().getRealPath("static/bbs/upload/headimg/"));
        File newFile = new File(request.getServletContext().getRealPath("static/bbs/upload/headimg/"), newFileName);
        newFile.getParentFile().mkdirs();
        System.out.println(newFile.getPath().toString());
        uploadFile.transferTo(newFile);
        user.setPhotoUrl("/static/bbs/upload/headimg/"+newFileName);
      //  user.setPhotoUrl("ji");/static/bbs/upload/headimg/first.jpg
       userDao.saveUpdate(user);
    //    ModelAndView mav = new ModelAndView("springmvc/showUploadedFile");
     //   mav.addObject("imageName", newFileName);
        return "redirect:/index.action";
    }
}
