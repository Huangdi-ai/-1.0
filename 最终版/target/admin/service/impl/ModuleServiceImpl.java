package com.admin.service.impl;

import com.admin.dao.ModuleDao;
import com.admin.service.ModuleService;
import com.common.pojo.SubForum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl  implements ModuleService {
    @Autowired
    ModuleDao moduleDao;
    @Override
    public List<SubForum> getForum() {
        return moduleDao.getForum();
    }


    @Override
    public boolean deleteSubForum(int id) {
        return moduleDao.deleteSubForum(id);
    }


    public Integer batchDelete(List<Integer>noticeIds){
        return moduleDao.batchDelete(noticeIds);
    }
    @Override
    public boolean updateSubForum(SubForum subForum){
        return moduleDao.updateSubforum(subForum);
    }

    @Override
    public boolean save(SubForum subForum){
        return moduleDao.save(subForum);
    }

    @Override
    public SubForum getForumById(Integer id) {return moduleDao. getFourmById(id);

    }
}
