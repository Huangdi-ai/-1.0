package com.admin.dao;



import com.common.pojo.User;

import java.util.List;

public interface MemberDao {
    public List<User> getUser();
    //后台====================
    public boolean deleteUser(int userId);

    public int batchDelete(List<Integer>userIds);

    public boolean blackUser(int id);

}
