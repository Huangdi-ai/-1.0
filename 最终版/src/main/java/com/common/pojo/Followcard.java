package com.common.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Followcard {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "post_id", nullable = true)
    private Integer postId;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "follow_content", nullable = true, length = 200)
    private String followContent;
    @Basic
    @Column(name = "follow_date", nullable = true)
    private Timestamp followDate;
    //* 一对一
    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;
}
