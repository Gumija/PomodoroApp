package com.milang.pomodoroapp;

import com.milang.pomodoroapp.interactor.InteractorModule;
import com.milang.pomodoroapp.model.ModelModule;
import com.milang.pomodoroapp.network.NetworkModule;
import com.milang.pomodoroapp.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Felix on 4/25/2016.
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class})
public interface ApplicationComponent extends FlavorComponent {
}
