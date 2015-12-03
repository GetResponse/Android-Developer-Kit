package com.getresponse.sdk.modules;

import com.getresponse.sdk.GetResponseApi;
import com.getresponse.sdk.models.Campaign;
import com.getresponse.sdk.models.Contact;
import com.github.kubatatami.judonetworking.callbacks.Callback;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ContactsTest {

    private static final String CAMPAIGN_NAME = "testCampaign";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    GetResponseApi mockGetResponseApi;

    Contacts classUnderTest;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new Contacts(mockGetResponseApi);
        Contacts.knownCampaigns.clear();
    }

    @Test
    public void addContactShouldThrowExceptionOnUnknownCampaignName() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Incorrect campaign name");

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Callback callback = (Callback<List<Campaign>>) invocation.getArguments()[1];
                callback.onSuccess(new ArrayList<List<Campaign>>());
                return null;
            }
        }).when(mockGetResponseApi).getCampaign(eq(CAMPAIGN_NAME), any(Callback.class));

        classUnderTest.addSimpleContact(CAMPAIGN_NAME, null, null, null);

        verify(mockGetResponseApi, times(1)).getCampaign(eq(CAMPAIGN_NAME), any(Callback.class));
    }

    @Test
    public void addContactShouldDownloadCampaignForCampaignName() {
        Campaign campaignMock = mock(Campaign.class);
        final List<Campaign> campaignList = new ArrayList<>();
        campaignList.add(campaignMock);
        Callback expectedCallback = mock(Callback.class);

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Callback callback = (Callback<List<Campaign>>) invocation.getArguments()[1];
                callback.onSuccess(campaignList);
                return null;
            }
        }).when(mockGetResponseApi).getCampaign(eq(CAMPAIGN_NAME), any(Callback.class));

        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) {
                Callback callback = (Callback<List<Campaign>>) invocation.getArguments()[1];
                callback.onSuccess(new ArrayList<List<Campaign>>());
                return null;
            }
        }).when(mockGetResponseApi).addContact(any(Contact.class), eq(expectedCallback));

        classUnderTest.addSimpleContact(CAMPAIGN_NAME, null, null, expectedCallback);

        verify(mockGetResponseApi, times(1)).getCampaign(eq(CAMPAIGN_NAME), any(Callback.class));
        verify(mockGetResponseApi, times(1)).addContact(any(Contact.class), eq(expectedCallback));
    }

    @Test
    public void addContactShouldDownloadCampaignOnlyOnce() {
        addContactShouldDownloadCampaignForCampaignName();

        classUnderTest.addSimpleContact(CAMPAIGN_NAME, null, null, null);

        verify(mockGetResponseApi, times(1)).getCampaign(eq(CAMPAIGN_NAME), any(Callback.class));
        verify(mockGetResponseApi, times(2)).addContact(any(Contact.class), any(Callback.class));
    }
}