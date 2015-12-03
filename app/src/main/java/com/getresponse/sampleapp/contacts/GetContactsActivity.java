package com.getresponse.sampleapp.contacts;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.getresponse.sampleapp.Config;
import com.getresponse.sampleapp.GRCallback;
import com.getresponse.sampleapp.GrActivity;
import com.getresponse.sampleapp.R;
import com.getresponse.sdk.models.Contact;

import java.util.List;

public class GetContactsActivity extends GrActivity {

    ListView contactList;

    private ArrayAdapter<Contact> contactListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_contact);
        contactList = (ListView) findViewById(R.id.contact_list);
        contactListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        contactList.setAdapter(contactListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.get_contact, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.isEmpty()) {
                    contactListAdapter.clear();
                    return false;
                }
                grApi.getContacts().getContactsByEmail(Config.CAMPAIGN_NAME, query, new GRCallback<List<Contact>>(GetContactsActivity.this) {
                    @Override
                    public void onSuccess(List<Contact> contacts) {
                        contactListAdapter.setNotifyOnChange(false);
                        contactListAdapter.clear();
                        contactListAdapter.addAll(contacts);
                        contactListAdapter.notifyDataSetChanged();
                        super.onSuccess(contacts);
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        MenuItemCompat.expandActionView(menu.findItem(R.id.action_search));
        searchView.requestFocus();
        return true;
    }
}
