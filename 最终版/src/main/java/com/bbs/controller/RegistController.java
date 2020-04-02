package com.bbs.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.bbs.dao.UserDao;

import com.common.constant.Constant;
import com.common.pojo.User;
import com.common.util.aliyunmessage.AliyunSmsUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

import static com.common.util.aliyunmessage.AliyunSmsUtils.getNewcode;
import static com.common.util.aliyunmessage.AliyunSmsUtils.sendSms;

@Controller
public class RegistController {
    @Autowired
    UserDao userDao;
    private String username;
    private String password;
    private String email;
    @RequestMapping("/Aliyunmessage")
    @ResponseBody
    public Integer sendMessage(String phone, HttpSession session) throws ClientException {
        AliyunSmsUtils.setNewcode();
        System.out.println("=============="+phone);
        String code = Integer.toString(getNewcode());
        System.out.println("发送的验证码为：" + code);
        session.setAttribute("smsCode",code);
        //发短信
        SendSmsResponse response = sendSms(phone, code); // TODO 填写你需要测试的手机号码
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());
        return 200;
    }
    @RequestMapping("/regist")
    //@RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String regist(User user, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        String volicode = request.getParameter("volidcode");
        String smscode = (String) session.getAttribute("smsCode");
        if (!volicode.equals(smscode)) {
            return "redirect:/registjsp.action";
        } else {
            username = request.getParameter("username");
            password = request.getParameter("password");
            email = request.getParameter("email");
            System.out.println(username);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhotoUrl("/static/bbs/upload/headimg/702b8819-c250-41db-87f0-6c8557ef306f.jpg");
            System.out.println(user.getEmail());

            if (userDao.isExist(user) > 0)
                return Constant.LoginAndRegisterPrefixJSP + "regist_false.jsp";
            user.setLevel(1);
            user.setType(1);
            user.setSex("男");
            user.setRegisterDate(new Timestamp(System.currentTimeMillis()));
            user.setHasActive(1);
            user.setPhotoUrl("/upload/default/head_icon.jpg");//默认头像
            userDao.regist(user);
            return Constant.LoginAndRegisterPrefixJSP + "regist_success.jsp";
        }
    }

}
