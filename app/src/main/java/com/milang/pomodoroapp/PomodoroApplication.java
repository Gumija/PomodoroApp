package com.milang.pomodoroapp;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.milang.pomodoroapp.interactor.ComponentFactory;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.orm.SugarApp;
import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;
import com.orm.util.SugarConfig;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import io.fabric.sdk.android.Fabric;


/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class PomodoroApplication extends SugarApp {

    private Tracker mTracker;

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }


    public static FlavorComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        injector = ComponentFactory.create(this);
        SugarContext.init(this);
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        SugarContext.terminate();
    }

    public void setInjector(FlavorComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
    }
}
