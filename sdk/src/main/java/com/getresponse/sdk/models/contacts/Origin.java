package com.getresponse.sdk.models.contacts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.kubatatami.judonetworking.controllers.json.JsonDefaultEnum;

public enum Origin {

    @JsonProperty("iphone")
    IPHONE,
    @JsonProperty("www")
    WWW,
    @JsonProperty("sale")
    SALE,
    @JsonProperty("leads")
    LEADS,
    @JsonProperty("forward")
    FORWARD,
    @JsonProperty("panel")
    PANEL,
    @JsonProperty("api")
    API,
    @JsonProperty("import")
    IMPORT,
    @JsonProperty("email")
    EMAIL,
    @JsonProperty("survey")
    SURVEY,
    @JsonProperty("copy")
    COPY,
    @JsonDefaultEnum
    UNKNOWN
}