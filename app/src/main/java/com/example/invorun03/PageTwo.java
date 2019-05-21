package com.example.invorun03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PageTwo extends AppCompatActivity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        String url = getIntent().getStringExtra("url");
        browser=findViewById(R.id.webview1);
        browser.setWebViewClient(new WebViewClient());
        WebSettings webSettings= browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        browser.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        browser.getSettings().setAppCacheEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSaveFormData(true);
        webSettings.setSavePassword(true);
        webSettings.setDatabaseEnabled(true);

        browser.loadUrl(url);
    }
}
