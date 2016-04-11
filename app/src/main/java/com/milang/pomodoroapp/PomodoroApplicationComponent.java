package com.milang.pomodoroapp;

import com.milang.pomodoroapp.interactor.InteractorModule;
import com.milang.pomodoroapp.model.ModelModule;
import com.milang.pomodoroapp.presenter.MainPresenter;
import com.milang.pomodoroapp.view.MainActivity;
import com.milang.pomodoroapp.interactor.IntInteractor;
import com.milang.pomodoroapp.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class})
public interface PomodoroApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(IntInteractor intInteractor);
}
