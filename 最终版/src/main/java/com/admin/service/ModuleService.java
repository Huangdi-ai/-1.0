package com.admin.service;

import com.common.pojo.SubForum;

import java.util.List;

public interface ModuleService {
    public List<SubForum> getForum();

    public boolean updateSubForum(SubForum subForum);

    public boolean save(SubForum subForum);

    public Integer batchDelete(List<Integer> id);
    public boolean deleteSubForum(int id);

    public SubForum getForumById(Integer id);
}
