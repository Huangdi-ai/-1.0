package com.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Table(name = "main_forum", schema = "bbs", catalog = "")
public class MainForum {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "title", nullable = true, length = 20)
    private String title;
    @Basic
    @Column(name = "info", nullable = true, length = 60)
    private String info;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="main_forum_id")
    @JsonIgnore
    private List<SubForum> subForum;
}