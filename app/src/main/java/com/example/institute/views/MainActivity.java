package com.example.institute.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.institute.R;
import com.example.institute.infrastructure.AppSettings;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView _view = findViewById(R.id.RenderBody);
        _view.setWebViewClient(new WebViewClient());
        _view.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        _view.getSettings().setJavaScriptEnabled(true);

        var url = Objects.requireNonNull(loadSettings()).getAppSettings().getBaseUrl();
        _view.loadUrl(url);
    }

    private AppSettings loadSettings() {
        try (InputStream inputStream = getAssets().open("appsettings.json")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String jsonContent = stringBuilder.toString();

            Gson gson = new Gson();
            return gson.fromJson(jsonContent, AppSettings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}