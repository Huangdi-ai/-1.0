package com.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Table(name = "user", schema = "bbs", catalog = "")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = true, length = 20)
    private String username;

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    private String password;
    @Basic
    @Column(name = "sex", nullable = true, length = 5)
    private String sex;
    @Basic
    @Column(name = "photo_url", nullable = true, length = -1)
    private String photoUrl;
    @Basic
    @Column(name = "email", nullable = true, length = 30)
    private String email;
    @Basic
    @Column(name = "type", nullable = true)
    private Integer type;
    @Basic
    @Column(name = "register_date", nullable = true)
    private Timestamp registerDate;
    @Basic
    @Column(name = "signature", nullable = true, length = 50)
    private String signature;
    @Basic
    @Column(name = "level", nullable = true)
    private Integer level;
    @Basic
    @Column(name = "active_code", nullable = true, length = 32)
    private String activeCode;
    @Basic
    @Column(name = "hasActive", nullable = true)
    private Integer hasActive;
    /**
     * 一多对
     */
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<Followcard> followcardSet = new HashSet<>();
}