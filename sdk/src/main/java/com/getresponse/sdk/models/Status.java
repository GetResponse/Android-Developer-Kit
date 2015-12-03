package com.getresponse.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.kubatatami.judonetworking.controllers.json.JsonDefaultEnum;

public enum Status {
    @JsonProperty("enabled")
    ENABLED,
    @JsonDefaultEnum
    @JsonProperty("disabled")
    DISABLED
}
