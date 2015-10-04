package com.unicornunicode.stephenkairos.ymcavolunteer;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by StephenKairos on 10/3/2015.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "Aekvf8WhmDKX9HGXlXuH7x5X3BE2KSv12EmaNY1K", "xZEb5pHtWwPPHDqgHPqejVLM6dcAFr6tLhDbWydY");


    }
}