package com.getresponse.sdk.models.custom_fields;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.kubatatami.judonetworking.controllers.json.JsonDefaultEnum;

public enum FieldType {

    @JsonProperty("text")
    TEXT,
    @JsonProperty("textarea")
    TEXTAREA,
    @JsonProperty("radio")
    RADIO,
    @JsonProperty("single_select")
    SINGLE_SELECT,
    @JsonProperty("multi_select")
    MULTI_SELECT,
    @JsonDefaultEnum
    UNKNOWN
}
