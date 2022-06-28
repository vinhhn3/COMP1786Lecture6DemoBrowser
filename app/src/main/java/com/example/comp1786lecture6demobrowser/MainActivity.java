package com.example.comp1786lecture6demobrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView browser;

    private final String url = "https://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = findViewById(R.id.myWebView);

        browser.getSettings().setBuiltInZoomControls(true);

        browser.loadUrl(url);
    }
}