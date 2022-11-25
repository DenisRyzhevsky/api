package com.apitest.Springboottest.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class UserEntity {
    public UserEntity(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avatar")
    private String photourl;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "online")
    private Boolean online;

    @Column(name = "status_timestamp")
    private Timestamp statusTimestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean isOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Timestamp getStatusTimestamp() {
        return statusTimestamp;
    }

    public void setStatusTimestamp(Timestamp statusTimestamp) {
        this.statusTimestamp = statusTimestamp;
    }
}
