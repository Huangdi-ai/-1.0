package com.common.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "sub_forum_id", nullable = true)
    private Integer subForumId;
    @Basic
    @Column(name = "user_id", nullable = true)
    private Integer userId;
    @Basic
    @Column(name = "title", nullable = true, length = 40)
    private String title;
    @Basic
    @Column(name = "card_content", nullable = true, length = 500)
    private String cardContent;
    @Basic
    @Column(name = "send_date", nullable = true)
    private Date sendDate;
    @Basic
    @Column(name = "post_type", nullable = true)
    private Integer postType;
    @Basic
    @Column(name = "reply_num", nullable = true)
    private Integer replyNum;
    @Basic
    @Column(name = "view_num", nullable = true)
    private Integer viewNum;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Followcard> followcardSet = new ArrayList<>();

    @JsonIgnore
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonIgnore
    @JoinColumn(name = "sub_forum_id", insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private SubForum subForum;
}