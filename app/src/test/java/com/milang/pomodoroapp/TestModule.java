package com.milang.pomodoroapp;

import android.content.Context;

import com.milang.pomodoroapp.model.IntModel;
import com.milang.pomodoroapp.model.ModelModule;
import com.milang.pomodoroapp.model.SugarModel;
import com.milang.pomodoroapp.presenter.ActivityListPresenter;
import com.milang.pomodoroapp.presenter.MainPresenter;
import com.milang.pomodoroapp.presenter.RecordsPresenter;
import com.milang.pomodoroapp.presenter.ToDoTodayPresenter;
import com.milang.pomodoroapp.view.ViewModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    private final ViewModule viewModule;
    private final ModelModule modelModule;

    public TestModule(Context context) {

        this.viewModule = new ViewModule(context);
        this.modelModule = new ModelModule();
    }

    @Provides
    public Context provideContext() {
        return viewModule.provideContext();
    }

    @Provides
    public SugarModel provideSugarModel() {
        return modelModule.getSugarModel();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return viewModule.getMainPresenter();
    }

    @Provides
    public ActivityListPresenter provideActivityListPresenter() {
        return viewModule.getActivityListPresenter();
    }

    @Provides
    public ToDoTodayPresenter provideToDoToadyPresenter() {
        return viewModule.getToDoTodayPresenter();
    }

    @Provides
    public RecordsPresenter provideRecordsPresenter() {
        return viewModule.getRecordsPresenter();
    }

    @Provides
    public IntModel provideIntModel() {
        return modelModule.getIntModel();
    }
}
