package com.getresponse.sdk.models.custom_fields;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.kubatatami.judonetworking.controllers.json.JsonDefaultEnum;

public enum ValueType {
    @JsonProperty("string")
    STRING,
    @JsonProperty("url")
    URL,
    @JsonProperty("phone")
    PHONE,
    @JsonProperty("date")
    DATE,
    @JsonProperty("country")
    COUNTRY,
    @JsonProperty("number")
    NUMBER,
    @JsonDefaultEnum
    UNKNOWN
}
