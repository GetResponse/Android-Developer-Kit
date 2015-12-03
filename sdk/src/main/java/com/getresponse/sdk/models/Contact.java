package com.getresponse.sdk.models;

import android.webkit.WebStorage;

import com.getresponse.sdk.models.contacts.Origin;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {

    protected static final DateTimeFormatter fullFormat = DateTimeFormat.forPattern("dd - MM - yyyy HH:mm");

    protected static final DateTimeFormatter dateFormat = DateTimeFormat.forPattern("dd - MM - yyyy");

    protected static final DateTimeFormatter timeFormat = DateTimeFormat.forPattern("HH:mm");

    private String contactId;

    private String name;

    private String email;

    private Origin origin;

    private String dayOfCycle;

    private LocalDateTime createdOn;

    private Campaign campaign;

    private String ipAddress;

    private String note;

    private LocalDateTime changedOn;

    private String timeZone;

    private GeoLocation geolocation;

    private List<CustomField> customFieldValues;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getChangedOn() {
        return changedOn;
    }

    public void setChangedOn(LocalDateTime changedOn) {
        this.changedOn = changedOn;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public List<CustomField> getCustomFieldValues() {
        return customFieldValues;
    }

    public void setCustomFieldsValues(List<CustomField> customFieldValues) {
        this.customFieldValues = customFieldValues;
    }

    public String getFormattedCreatedOn() {
        return fullFormat.print(getCreatedOn());
    }

    public String getFormattedDateCreatedOn() {
        return dateFormat.print(getCreatedOn());
    }

    public String getFormattedTimeCreatedOn() {
        return timeFormat.print(getCreatedOn());
    }

    @Override
    public String toString() {
        return getName() + " : " + getEmail();
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String id) {
        this.contactId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Integer getDayOfCycle() {
        return dayOfCycle == null || "null".equals(dayOfCycle) ? null : Integer.valueOf(dayOfCycle);
    }

    public void setDayOfCycle(Integer dayOfCycle) {
        this.dayOfCycle = dayOfCycle == null ? "null" : dayOfCycle.toString();
    }

    //API treats this null string as if it should remove dayOfCycleValue
    public void disableDayOfCycle() {
        this.dayOfCycle = "null";
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIp(String ip) {
        this.ipAddress = ip;
    }

    public GeoLocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(GeoLocation geolocation) {
        this.geolocation = geolocation;
    }

}
