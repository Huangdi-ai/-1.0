package com.admin.dao;

import com.common.pojo.SubForum;

import java.util.List;

public interface ModuleDao {
    public List<SubForum> getForum();

    boolean deleteSubForum(int Id);

    Integer batchDelete(List<Integer> Ids);

    boolean save(SubForum subForum);

    SubForum getFourmById(Integer id);

    boolean updateSubforum(SubForum subForum);
}
