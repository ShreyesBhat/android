package com.mrbing.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    Button btnSendEmail;
    Button btnPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = findViewById(R.id.btnSendSMS);
        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnPhone = findViewById(R.id.btnDialPhone);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneDial();
            }
        });
    }

    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ba.mohan@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Test");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Message Body Test");
        startActivity(emailIntent);
    }

    protected void sendSMSMessage() {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("sms_body", "default content");
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
        Toast.makeText(getApplicationContext(), "SMS Sent", Toast.LENGTH_LONG).show();
    }

    protected void PhoneDial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
}
