package com.osmany.simplegram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;


public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("x6Xry5lSLj81pD5vpIjP4vFkuSPrDccn4djuX0WF")
                .clientKey("dSWZoOatF5nrBbq3NT5j7mLyqFTO9xhqoXp1pS3V")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }

}

