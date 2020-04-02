package com.admin.service.impl;

import com.admin.dao.ModuleDao;
import com.admin.service.ModuleService;
import com.common.pojo.SubForum;
import com.sun.mail.imap.protocol.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
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


    public Integer batchDelete(List<Integer>id){
        return moduleDao.batchDelete(id);
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
