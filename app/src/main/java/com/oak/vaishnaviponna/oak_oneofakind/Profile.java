package com.oak.vaishnaviponna.oak_oneofakind;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Profile extends AppCompatActivity {
    TextView username;
    private Button mail,phoneno;
    private String number;
    Context cntext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = (TextView) findViewById(R.id.tvEmailProfile);
       username.setText(getIntent().getExtras().getString("username"));
        mail = (Button) findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String[] TO = {getIntent().getExtras().getString("Email")};
                String[] CC = {"oakoneofakind@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Customize designs");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email designer");
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            }
        });
        phoneno = (Button) findViewById(R.id.call);
        number = getIntent().getExtras().getString("phoneno");
        phoneno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });

    }
}
