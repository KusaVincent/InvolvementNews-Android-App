package com.example.invorun03;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {

    TextView pn1, pn2, pn3, email1, email2, email3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        pn1 = findViewById(R.id.pn1);
        pn2 = findViewById(R.id.pn2);
        pn3 = findViewById(R.id.pn3);
        email1=findViewById(R.id.email1);
        email2=findViewById(R.id.email2);
        email3=findViewById(R.id.email3);


        pn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+Uri.encode("0798749323")));
                startActivity(i);
            }
        });

        pn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+Uri.encode("0745858891")));
                startActivity(i);
            }
        });

        pn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+Uri.encode("0716370732")));
                startActivity(i);
            }
        });

        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailintent= new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "vinonyi21@gmail.com", null));
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailintent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailintent, "Send Email..."));
            }
        });

        email2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailintent= new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "pmanyara97@gmail.com", null));
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailintent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailintent, "Send Email..."));
            }
        });

        email3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailintent= new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "invo.feedback@gmail.com", null));
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailintent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailintent, "Send Email..."));
            }
        });
    }
}
