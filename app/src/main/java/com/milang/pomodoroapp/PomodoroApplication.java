package com.milang.pomodoroapp;

import android.app.Application;

import com.milang.pomodoroapp.view.ViewModule;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class PomodoroApplication extends Application {

    public static PomodoroApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerPomodoroApplicationComponent.builder().viewModule(new ViewModule(this)).build();
    }
}
