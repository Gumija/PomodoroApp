package com.milang.pomodoroapp;

import com.milang.pomodoroapp.PomodoroApplication;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;


public class TestHelper {

    public static void setTestInjector() {
        PomodoroApplication application = (PomodoroApplication)RuntimeEnvironment.application;
        ApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}
