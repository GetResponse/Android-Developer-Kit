package com.getresponse.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.kubatatami.judonetworking.controllers.json.JsonDefaultEnum;

public enum Optin {
    @JsonProperty("single")
    SINGLE,
    @JsonProperty("double")
    DOUBLE,
    @JsonDefaultEnum
    UNKNOWN
}
