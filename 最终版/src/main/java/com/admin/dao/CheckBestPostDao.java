package com.admin.dao;

import com.common.pojo.BestPost;

import java.util.List;

public interface CheckBestPostDao {
    public int saveBestPost(BestPost bestPost);
    public List<BestPost> getApplyRecord(Integer id);
    public List<BestPost> checkBestPostApply();
    public Integer applyok(Integer id);
    public Integer applydeny(Integer id);
}
