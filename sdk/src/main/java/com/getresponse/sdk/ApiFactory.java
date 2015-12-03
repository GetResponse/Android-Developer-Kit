package com.getresponse.sdk;

import android.content.Context;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.getresponse.sdk.modules.Contacts;
import com.github.kubatatami.judonetworking.Endpoint;
import com.github.kubatatami.judonetworking.EndpointFactory;
import com.github.kubatatami.judonetworking.Request;
import com.github.kubatatami.judonetworking.controllers.json.simple.JsonSimpleRestController;
import com.github.kubatatami.judonetworking.exceptions.JudoException;
import com.github.kubatatami.judonetworking.internals.EndpointBase;
import com.github.kubatatami.judonetworking.transports.OkHttpTransportLayer;

import java.util.HashMap;

public class ApiFactory {

    private final String GETRESPONSE_API_URL = "https://api.getresponse.com/v3";

    private final GetResponseApi restApi;

    private final Endpoint endpoint;

    public ApiFactory(Context context, final String apiKey) {
        JsonSimpleRestController restController = new JsonSimpleRestController() {
            @Override
            public RequestInfo createRequest(String url, Request request) throws JudoException {
                RequestInfo requestInfo = super.createRequest(url, request);
                if (requestInfo.customHeaders == null) {
                    requestInfo.customHeaders = new HashMap<>();
                }
                requestInfo.customHeaders.put("X-Auth-Token", "api-key " + apiKey);
                requestInfo.customHeaders.put("Content-Type", "application/json");

                return requestInfo;
            }
        };
        restController.getMapper().enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        restController.getMapper().registerModule(new DateTimeModule());

        endpoint = EndpointFactory.createEndpoint(context, restController, new OkHttpTransportLayer(), GETRESPONSE_API_URL);
        restApi = endpoint.getService(GetResponseApi.class);
    }

    public void debugMode(boolean enabled) {
        endpoint.setDebugFlags(enabled ? EndpointBase.FULL_DEBUG : EndpointBase.NO_DEBUG);
    }

    public Contacts getContacts() {
        return new Contacts(restApi);
    }

}
