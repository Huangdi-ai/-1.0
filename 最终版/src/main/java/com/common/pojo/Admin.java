package com.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Table(name = "admin", schema = "bbs", catalog = "")
public class Admin {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "user_name", nullable = true, length = 20)
    private String userName;
    @Basic
    @Column(name = "password", nullable = true, length = 20)
    private String password;
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
    @Column(name = "sex", nullable = true, length = 10)
    private String sex;

}