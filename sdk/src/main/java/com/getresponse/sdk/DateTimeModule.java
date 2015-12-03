package com.getresponse.sdk;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

import java.io.IOException;

class DateTimeModule extends SimpleModule {

    public static final DateTimeParser[] parsers = {
            DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ").getParser(),
            DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss").getParser(),
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").getParser(),
            DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").getParser(),
            DateTimeFormat.forPattern("yyyy-MM-dd HH").getParser(),
            DateTimeFormat.forPattern("yyyy-MM-dd").getParser(),
            DateTimeFormat.forPattern("yyyy-MM").getParser(),
            DateTimeFormat.forPattern("yyyy").getParser()};

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd").withZoneUTC();

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm:ss").withZoneUTC();

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'+0'").withZoneUTC();

    public static final DateTimeFormatter REST_DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'+0000'").withZoneUTC();

    public static final DateTimeFormatter DATE_TIME_UNIVERSAL_FORMATTER = new DateTimeFormatterBuilder().append(null, parsers).toFormatter().withZoneUTC();


    public DateTimeModule() {
        super("date-time-module", new Version(1, 0, 0, "", DateTimeModule.class.getPackage().getName(), ""));
        addDeserializer(LocalDateTime.class, new DateTimeDeserializer());
        addSerializer(LocalDateTime.class, new DateTimeSerializer());
        addKeyDeserializer(LocalDateTime.class, new KeyDateTimeDeserializer());

    }


    public static class DateSerializer extends StdSerializer<LocalDateTime> {


        protected DateSerializer() {
            super(LocalDateTime.class);
        }

        @Override
        public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(value.toString(DATE_FORMATTER));
        }
    }

    public static class TimeSerializer extends StdSerializer<LocalDateTime> {


        protected TimeSerializer() {
            super(LocalDateTime.class);
        }

        @Override
        public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(value.toString(TIME_FORMATTER));
        }
    }

    public static class DateTimeSerializer extends StdSerializer<LocalDateTime> {


        protected DateTimeSerializer() {
            super(LocalDateTime.class);
        }

        @Override
        public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeString(value.toDateTime().toString(DATE_TIME_FORMATTER));
        }
    }

    public static class DateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            try {
                String dateTime = jp.getText();
                if (dateTime.contains("/")) {
                    dateTime = dateTime.substring(0, dateTime.indexOf("/"));
                }
                return DATE_TIME_UNIVERSAL_FORMATTER.parseDateTime(dateTime).withZone(DateTimeZone.getDefault()).toLocalDateTime();
            } catch (IllegalFieldValueException ex) {
                return null;
            } catch (IllegalArgumentException ex) {
                return null;
            }
        }

    }

    public static class KeyDateTimeDeserializer extends KeyDeserializer {

        @Override
        public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
            try {
                return DATE_TIME_UNIVERSAL_FORMATTER.parseDateTime(key).toLocalDateTime();
            } catch (IllegalFieldValueException ex) {
                return null;
            } catch (IllegalArgumentException ex) {
                return null;
            }
        }
    }

}