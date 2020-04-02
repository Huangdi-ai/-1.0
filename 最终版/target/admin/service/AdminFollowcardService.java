package com.admin.service;

import java.util.List;
import java.util.Map;

public interface AdminFollowcardService {
    //后台====================
    public List<Map<String,Object>> getAllFollowcards();

    public boolean deleteFollowcard(int followcardId);

    public int batchDelete(List<Integer>followcardIds);
}
