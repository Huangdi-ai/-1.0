package com.bbs.dao;




import com.common.pojo.MainForum;
import com.common.pojo.SubForum;

import java.util.List;

public interface MainForumDao {

    public List<SubForum> getAll();
}
