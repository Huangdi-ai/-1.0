package com.common.pojo;

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
@Table(name = "best_post", schema = "bbs", catalog = "")
public class BestPost {
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
    @Column(name = "apply_date", nullable = true)
    private Timestamp applyDate;
    @Basic
    @Column(name = "state", nullable = true)
    private Integer state;

    @JsonIgnore
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private Post post;
}
