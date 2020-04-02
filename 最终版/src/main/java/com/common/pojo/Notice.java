package com.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Notice {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "admin_id", nullable = true)
    private Integer adminId;
    @Basic
    @Column(name = "content", nullable = true, length = 200)
    private String content;
    @Basic
    @Column(name = "notice_date", nullable = true)
    private Timestamp noticeDate;
    @Basic
    @Column(name = "title", nullable = true, length = 45)
    private String title;
}
