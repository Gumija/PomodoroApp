package com.milang.pomodoroapp;

import android.app.Application;

import com.milang.pomodoroapp.interactor.ComponentFactory;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.orm.SugarApp;
import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;
import com.orm.util.SugarConfig;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class PomodoroApplication extends SugarApp {

    public static FlavorComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = ComponentFactory.create(this);
        SugarContext.init(this);
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
        SugarContext.terminate();
    }
}
