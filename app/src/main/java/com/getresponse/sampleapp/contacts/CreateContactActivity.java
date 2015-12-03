package com.getresponse.sampleapp.contacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.getresponse.sampleapp.Config;
import com.getresponse.sampleapp.GRCallback;
import com.getresponse.sampleapp.GrActivity;
import com.getresponse.sampleapp.R;

public class CreateContactActivity extends GrActivity {

    private FloatingActionButton fab;

    private TextView name;

    private TextView email;

    private TextWatcher textWatcher = new SimpleTextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkFieldsForEmptyValues();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);

        name.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);

        final View rootView = findViewById(R.id.root_view);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grApi.getContacts().addSimpleContact(Config.CAMPAIGN_NAME, name.getText().toString(), email.getText().toString(), new GRCallback<Void>(CreateContactActivity.this) {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Snackbar.make(rootView, "Contact added", Snackbar.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void checkFieldsForEmptyValues() {
        if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty()) {
            fab.show();
        } else {
            if (fab.getVisibility() == View.VISIBLE) {
                fab.hide();
            }
        }
    }

}
