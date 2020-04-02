package com.bbs.service.impl;

import com.bbs.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceimplTest {
    private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }
    @Test
    public void getUserById() {
        UserDaoImpl postAndFollowDaoImpl = (UserDaoImpl) applicationContext.getBean("userDaoImpl");
        postAndFollowDaoImpl.getUserById(1);
    }
}