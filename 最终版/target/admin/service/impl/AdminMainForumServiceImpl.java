package com.admin.service.impl;

import com.admin.dao.AdminMainForumDao;
import com.common.pojo.MainForum;
import com.admin.service.AdminMainForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminMainForumServiceImpl implements AdminMainForumService {
    @Autowired
    AdminMainForumDao adminMainForumDao;

	@Override
	public List<MainForum> getAll() {
		List<MainForum>list= adminMainForumDao.getAll();
		return list;
	}
}
