package com.getresponse.sdk;

import com.getresponse.sdk.models.Campaign;
import com.getresponse.sdk.models.Contact;
import com.github.kubatatami.judonetworking.AsyncResult;
import com.github.kubatatami.judonetworking.annotations.RequestMethod;
import com.github.kubatatami.judonetworking.callbacks.Callback;
import com.github.kubatatami.judonetworking.controllers.json.simple.JsonSimpleRestController;
import com.github.kubatatami.judonetworking.controllers.raw.RawRestController;
import com.github.kubatatami.judonetworking.transports.HttpTransportLayer;

import java.util.List;

public interface GetResponseApi {

    @RawRestController.Rest("contacts")
    @JsonSimpleRestController.JsonPost(singleFlat = true)
    @RequestMethod
    AsyncResult addContact(@RawRestController.Post Contact contact, Callback<Void> callback);

    @RawRestController.Rest("campaigns?query[name]={0}")
    @RequestMethod
    AsyncResult getCampaign(String campaignName, Callback<List<Campaign>> callback);

    @RawRestController.Rest("contacts?query[campaignId]={0}&query[email]={1}")
    @RequestMethod
    AsyncResult getContacts(String campaignId, String email, Callback<List<Contact>> callback);

    @RawRestController.Rest("contacts/{0}")
    @HttpTransportLayer.HttpMethod("DELETE")
    @RequestMethod
    AsyncResult deleteContact(String contactId, Callback<Void> callback);
}
