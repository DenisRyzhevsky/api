package com.apitest.Springboottest.model;


import com.apitest.Springboottest.entity.UserEntity;

import javax.persistence.Column;

public class Status {

    private Long id;

    @Column(name = "oldStatus")
    private Boolean oldStatus;

    @Column(name = "currentStatus")
    private Boolean currentStatus;

    public Status(){
    }

    public static Status toModel(UserEntity entity) {
        Status status = new Status();
        status.setId(entity.getId());
        status.setOldStatus(!entity.isOnline("old"));
        status.setCurrentStatus(entity.isOnline("current"));
        return status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Boolean oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Boolean getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Boolean currentStatus) {
        this.currentStatus = currentStatus;
    }
}
