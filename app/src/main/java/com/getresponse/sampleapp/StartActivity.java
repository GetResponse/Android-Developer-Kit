package com.getresponse.sampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.getresponse.sampleapp.contacts.CreateContactActivity;
import com.getresponse.sampleapp.contacts.DeleteContactActivity;
import com.getresponse.sampleapp.contacts.GetContactsActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        NavigationView navigationView = (NavigationView) findViewById(R.id.menu_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_add_contact:
                        return startActivity(CreateContactActivity.class);
                    case R.id.menu_get_contact:
                        return startActivity(GetContactsActivity.class);
                    case R.id.menu_delete_contact:
                        return startActivity(DeleteContactActivity.class);
                }
                return true;
            }
        });
    }

    private boolean startActivity(Class<?> className) {
        Intent intent = new Intent(this, className);
        startActivity(intent);
        return true;
    }
}
