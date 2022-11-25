package com.apitest.Springboottest.model;


import com.apitest.Springboottest.entity.UserEntity;

public class Status {

    private Long id;

    private Boolean oldStatus;

    private Boolean currentStatus;

    public Status(){
    }

    public static Status toModel(UserEntity entity) {
        Status status = new Status();
        status.setId(entity.getId());
        status.setOldStatus(!entity.isOnline());
        status.setCurrentStatus(entity.isOnline());
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
