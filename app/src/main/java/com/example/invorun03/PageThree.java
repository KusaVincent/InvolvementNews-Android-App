package com.example.invorun03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class PageThree extends AppCompatActivity {
    WebView browser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);

        browser2=findViewById(R.id.webview2);
    }
}
