package com.ahsan.intiser.daoexample;

import android.app.Application;
import android.content.Context;

/**
 * Created by Intiser on 11/30/2018.
 */

public class SampleApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }

}
