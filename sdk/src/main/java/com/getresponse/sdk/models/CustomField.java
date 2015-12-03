package com.getresponse.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.getresponse.sdk.models.custom_fields.FieldType;
import com.getresponse.sdk.models.custom_fields.ValueType;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CustomField implements Serializable {

    @JsonProperty("customFieldId")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    private String name;

    private FieldType fieldType;

    private ValueType valueType;

    private boolean hidden;

    private List<String> values = new LinkedList<>();

    public String getId() {
        return id;
    }

    public void setId(String customFieldId) {
        this.id = customFieldId;
    }

    //TEMPORARY SOLUTION?
    public void addSingleValue(String value) {
        if (values.isEmpty()) {
            values.add(value);
        } else {
            values.set(0, value);
        }
    }

    //TEMPORARY SOLUTION?
    public String getSingleValue() {
        return values.isEmpty() ? "" : values.get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomField that = (CustomField) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
