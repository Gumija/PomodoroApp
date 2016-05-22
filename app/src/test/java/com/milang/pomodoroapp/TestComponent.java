package com.milang.pomodoroapp;

import com.milang.pomodoroapp.ApplicationComponent;
import com.milang.pomodoroapp.interactor.InteractorModule;
import com.milang.pomodoroapp.model.ModelModule;
import com.milang.pomodoroapp.network.NetworkModule;
import com.milang.pomodoroapp.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends ApplicationComponent {
}
