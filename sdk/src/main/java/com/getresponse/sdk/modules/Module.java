package com.getresponse.sdk.modules;

import com.getresponse.sdk.GetResponseApi;
import com.getresponse.sdk.models.Campaign;
import com.github.kubatatami.judonetworking.callbacks.DefaultCallback;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Module {

    protected static final Map<String, Campaign> knownCampaigns = Collections.synchronizedMap(new HashMap<String, Campaign>());

    protected final GetResponseApi getResponseApi;

    public Module(GetResponseApi getResponseApi) {
        this.getResponseApi = getResponseApi;
    }

    protected interface CampaignNameAwareCall {

        void run(Campaign campaign);
    }

    protected void runWithCampaignName(final String campaignName, final CampaignNameAwareCall realCall) {
        if (knownCampaigns.containsKey(campaignName)) {
            realCall.run(knownCampaigns.get(campaignName));
        } else {
            getResponseApi.getCampaign(campaignName, new DefaultCallback<List<Campaign>>() {
                @Override
                public void onSuccess(List<Campaign> campaigns) {
                    if (campaigns.isEmpty()) {
                        throw new IllegalArgumentException("Incorrect campaign name");
                    }
                    knownCampaigns.put(campaignName, campaigns.get(0));
                    realCall.run(knownCampaigns.get(campaignName));
                }
            });
        }
    }

}
