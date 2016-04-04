package br.com.rads.nasathings;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by Rafael on 3/27/16.
 */
public class NasaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }
}
