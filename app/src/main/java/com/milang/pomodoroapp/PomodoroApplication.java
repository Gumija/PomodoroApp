package com.milang.pomodoroapp;

import android.app.Application;

import com.milang.pomodoroapp.interactor.ComponentFactory;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class PomodoroApplication extends Application {

    public static FlavorComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = ComponentFactory.create(this);
    }
}
