package com.milang.pomodoroapp.interactor;

import android.app.Application;

import com.milang.pomodoroapp.DaggerApplicationComponent;
import com.milang.pomodoroapp.FlavorComponent;
import com.milang.pomodoroapp.view.ViewModule;

/**
 * Created by Felix on 4/25/2016.
 */
public class ComponentFactory {

    public static FlavorComponent create(Application context) {
        return DaggerApplicationComponent.builder()
                .viewModule(new ViewModule(context))
                .build();
    }
}
