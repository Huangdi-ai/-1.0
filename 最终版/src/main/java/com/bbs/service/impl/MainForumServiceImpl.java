package com.bbs.service.impl;

import com.bbs.dao.MainForumDao;
import com.bbs.service.MainForumService;
import com.common.pojo.MainForum;
import com.common.pojo.SubForum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MainForumServiceImpl implements MainForumService {
    @Autowired
	MainForumDao mainForumDao;

	@Override
	public List<SubForum> getAll() {
		List<SubForum>list=mainForumDao.getAll();
		return list;
	}
}
