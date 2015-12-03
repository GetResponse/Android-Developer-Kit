package com.getresponse.sdk.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.LocalDateTime;

import java.io.Serializable;
import java.util.List;

public class Campaign implements Serializable, Comparable<Campaign> {

    private static final long serialVersionUID = -6166357829892034414L;

    private String campaignId;

    private String name;

    private String description;

    private String languageCode;

    private Boolean isDefault;

    private LocalDateTime createdOn;

    private Confirmation confirmation;

    private Profile profile;

    private Postal postal;

    private OptinTypes optinTypes;

    private SubscriptionNotifications subscriptionNotifications;

    public Campaign() {
    }

    public Campaign(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Boolean isDefault() {
        return isDefault;
    }

    public void setDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Confirmation getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Confirmation confirmation) {
        this.confirmation = confirmation;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Postal getPostal() {
        return postal;
    }

    public void setPostal(Postal postal) {
        this.postal = postal;
    }

    public OptinTypes getOptinTypes() {
        return optinTypes;
    }

    public void setOptinTypes(OptinTypes optinTypes) {
        this.optinTypes = optinTypes;
    }

    public SubscriptionNotifications getSubscriptionNotifications() {
        return subscriptionNotifications;
    }

    public void setSubscriptionNotifications(SubscriptionNotifications subscriptionNotifications) {
        this.subscriptionNotifications = subscriptionNotifications;
    }

    @Override
    public int compareTo(Campaign another) {
        return getName().compareTo(another.getName());
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof Campaign && getCampaignId().equals(((Campaign) o).getCampaignId());
    }

    @Override
    public int hashCode() {
        return getCampaignId().hashCode();
    }

    @Override
    public String toString() {
        // Safe to use name, name is unique in whole GR system.
        return getName();
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }


    public static class Confirmation implements Serializable {

        private FromField fromField;

        private FromField replyTo;

        private String redirectType;

        private String redirectUrl;

        private String mimeType;

        public FromField getFromField() {
            return fromField;
        }

        public void setFromField(FromField fromField) {
            this.fromField = fromField;
        }

        public FromField getReplyTo() {
            return replyTo;
        }

        public void setReplyTo(FromField replyTo) {
            this.replyTo = replyTo;
        }

        public String getRedirectType() {
            return redirectType;
        }

        public void setRedirectType(String redirectType) {
            this.redirectType = redirectType;
        }

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        public String getMimeType() {
            return mimeType;
        }

        public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
        }
    }

    public static class Profile implements Serializable {

        private String industryTagId;

        private String description;

        private String logo;

        private String redirectType;

        private String title;

        public String getIndustryTagId() {
            return industryTagId;
        }

        public void setIndustryTagId(String industryTagId) {
            this.industryTagId = industryTagId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getRedirectType() {
            return redirectType;
        }

        public void setRedirectType(String redirectType) {
            this.redirectType = redirectType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Postal implements Serializable {

        private String addPostalToMessages;

        private String city;

        private String companyName;

        private String country;

        private String design;

        private String state;

        private String street;

        private String zipCode;

        public String getAddPostalToMessages() {
            return addPostalToMessages;
        }

        public void setAddPostalToMessages(String addPostalToMessages) {
            this.addPostalToMessages = addPostalToMessages;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getDesign() {
            return design;
        }

        public void setDesign(String design) {
            this.design = design;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }

    public static class OptinTypes implements Serializable {

        private Optin email;

        @JsonProperty("import")
        private Optin imports;

        private Optin webform;

        public Optin getEmail() {
            return email;
        }

        public void setEmail(Optin email) {
            this.email = email;
        }

        public Optin getImports() {
            return imports;
        }

        public void setImports(Optin imports) {
            this.imports = imports;
        }

        public Optin getWebform() {
            return webform;
        }

        public void setWebform(Optin webform) {
            this.webform = webform;
        }
    }

    public static class SubscriptionNotifications implements Serializable {

        private Status status;

        private List<FromField> recipients;

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public List<FromField> getRecipients() {
            return recipients;
        }

        public void setRecipients(List<FromField> recipients) {
            this.recipients = recipients;
        }
    }

}

