package com.admin.dao;

import java.util.List;
import java.util.Map;

public interface AdminFollowcardDao {
    //后台====================
    public List<Map<String,Object>> getAllFollowcards();

    public boolean deleteFollowcard(int followcardId);

    public int batchDelete(List<Integer>followcardIds);
}
