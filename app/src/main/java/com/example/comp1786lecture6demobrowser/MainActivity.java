package com.example.comp1786lecture6demobrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private WebView browser;

    private final String url = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = findViewById(R.id.myWebView);

        browser.getSettings().setBuiltInZoomControls(true);

        browser.setWebViewClient(new BrowserDemoWebViewClient());

        browser.loadUrl(url);
    }
    private class BrowserDemoWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
            try{
                URL targetURL = new URL(request.getUrl().toString());
                String hostURL = targetURL.getProtocol() + "://" + targetURL.getHost();
                if(hostURL.equalsIgnoreCase(url)){
                    view.loadUrl(targetURL.toString());
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Sorry you can't leave google.com",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
            catch(MalformedURLException e){
                e.printStackTrace();
            }
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK)
            && browser.canGoBack()
        ){
            browser.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}