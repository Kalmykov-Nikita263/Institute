package com.example.institute.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.institute.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView _view = findViewById(R.id.RenderBody);
        _view.setWebViewClient(new WebViewClient());
        _view.getSettings().setJavaScriptEnabled(true);

        var url = "https://a18144-af18.b.d-f.pw/";
    }
}