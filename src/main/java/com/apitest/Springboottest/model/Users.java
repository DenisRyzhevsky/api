package com.apitest.Springboottest.model;

import com.apitest.Springboottest.entity.UserEntity;

import javax.persistence.Column;
import java.sql.Timestamp;

public class Users {

    private Long id;
    private String photourl;
    private String username;
    private String email;
    private String role;
    @Column(name = "online")
    private Boolean online;

    @Column(name = "status_timestamp")
    private Timestamp statusTimestamp;

    public Users(){
    }

    public static Users toModel(UserEntity entity) {
        Users model = new Users();
        model.setId(entity.getId());
        model.setPhotourl(entity.getPhotourl());
        model.setUsername(entity.getUsername());
        model.setEmail(entity.getEmail());
        model.setRole(entity.getRole());
        model.setOnline(entity.isOnline());
        model.setStatusTimestamp(entity.getStatusTimestamp());
        return model;
    }


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

