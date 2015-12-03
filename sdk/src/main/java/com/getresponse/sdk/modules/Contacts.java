package com.getresponse.sdk.modules;

import com.getresponse.sdk.GetResponseApi;
import com.getresponse.sdk.models.Campaign;
import com.getresponse.sdk.models.Contact;
import com.github.kubatatami.judonetworking.callbacks.Callback;

import java.util.List;

public class Contacts extends Module {

    public Contacts(GetResponseApi getResponseApi) {
        super(getResponseApi);
    }

    public void addSimpleContact(String campaignName, String contactName, String email, final Callback<Void> callback) {
        final Contact contact = new Contact();
        contact.setName(contactName);
        contact.setEmail(email);
        runWithCampaignName(campaignName, new CampaignNameAwareCall() {
            @Override
            public void run(Campaign campaign) {
                contact.setCampaign(campaign);
                getResponseApi.addContact(contact, callback);
            }
        });
    }

    public void getContactsByEmail(String campaignName, final String email, final Callback<List<Contact>> callback) {
        runWithCampaignName(campaignName, new CampaignNameAwareCall() {
            @Override
            public void run(Campaign campaign) {
                getResponseApi.getContacts(campaign.getCampaignId(), email, callback);
            }
        });
    }

    public void deleteContact(final String id, final Callback<Void> callback) {
        getResponseApi.deleteContact(id, callback);
    }
}
