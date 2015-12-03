package com.getresponse.sampleapp.contacts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.getresponse.sampleapp.Config;
import com.getresponse.sampleapp.GRCallback;
import com.getresponse.sampleapp.GrActivity;
import com.getresponse.sampleapp.R;
import com.getresponse.sdk.models.Contact;

import java.util.List;

public class DeleteContactActivity extends GrActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);

        final TextView email = (TextView) findViewById(R.id.email);
        final Button button = (Button) findViewById(R.id.delete_contact);

        email.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                button.setEnabled(!email.getText().toString().isEmpty());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grApi.getContacts().getContactsByEmail(Config.CAMPAIGN_NAME, email.getText().toString(), new GRCallback<List<Contact>>(DeleteContactActivity.this) {
                    @Override
                    public void onSuccess(List<Contact> contacts) {
                        if (contacts.isEmpty()) {
                            Toast.makeText(DeleteContactActivity.this, "Contact not found", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (contacts.size() > 1) {
                            Toast.makeText(DeleteContactActivity.this, "Ambiguous email search", Toast.LENGTH_LONG).show();
                            return;
                        }
                        grApi.getContacts().deleteContact(contacts.get(0).getContactId(), new GRCallback<Void>(DeleteContactActivity.this) {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(DeleteContactActivity.this, "Contact deleted", Toast.LENGTH_LONG).show();
                                email.setText("");
                            }
                        });
                    }
                });
            }
        });
    }


}
