package com.example.simplechat;

import android.app.Application;

import com.parse.Parse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Use for monitoring Parse network traffic
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // Can be Level.BASIC, Level.HEADERS, Level.BODY
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        // Set applicationId and server based on the values in the Heroku settings
        // Any network interceptors must be added with the configuration builder give this syntax
        Parse.initialize(new Parse.Configuration.Builder(this)
            .applicationId("simplechat-client")
            .clientBuilder(builder)
            .server("https://codepath-chat-lab.herokuapp.com/parse/")
            .build());
    }
}
