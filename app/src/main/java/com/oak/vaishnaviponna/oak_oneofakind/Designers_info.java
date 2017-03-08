package com.oak.vaishnaviponna.oak_oneofakind;

/**
 * Created by vaishnavi ponna on 02-01-2017.
 */
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Designers_info extends FragmentActivity {
    private Button button1,button2,button3;
    private String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designers_info);
        button1 = (Button) findViewById(R.id.call);
        number= "8106773069";
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });
        button2 = (Button) findViewById(R.id.message);
        number= "8106773069";
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);

                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address"  , number);
                smsIntent.putExtra("sms_body"  , "SMS designer ");
                startActivity(smsIntent);
            }
        });
        button3 = (Button) findViewById(R.id.mail);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String[] TO = {"ravali.namburi95@gmail.com"};
                String[] CC = {"vaishnaviponna111@gmail.com"};
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
    }
}
