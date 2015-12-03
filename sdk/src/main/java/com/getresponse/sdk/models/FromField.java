package com.getresponse.sdk.models;

import org.joda.time.LocalDateTime;

import java.io.Serializable;

public class FromField implements Serializable {

    private String fromFieldId;

    private String email;

    private String name;

    private Boolean isActive;

    private Boolean isDefault;

    private LocalDateTime createdOn;

    private String href;

    public FromField() {
    }

    public FromField(String fromFieldId) {
        this.fromFieldId = fromFieldId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getFromFieldId() {
        return fromFieldId;
    }

    public void setFromFieldId(String fromFieldId) {
        this.fromFieldId = fromFieldId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return name + " <" + email + ">";
    }
}
