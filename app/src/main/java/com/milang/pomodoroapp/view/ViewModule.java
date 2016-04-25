package com.milang.pomodoroapp.view;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.milang.pomodoroapp.presenter.ActivityListPresenter;
import com.milang.pomodoroapp.presenter.MainPresenter;
import com.milang.pomodoroapp.presenter.RecordsPresenter;
import com.milang.pomodoroapp.presenter.ToDoTodayPresenter;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
@Module
public class ViewModule {
    private Context  context;

    public ViewModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter getMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public ActivityListPresenter getActivityListPresenter() {
        return new ActivityListPresenter();
    }

    @Provides
    @Singleton
    public ToDoTodayPresenter getToDoTodayPresenter() {
        return new ToDoTodayPresenter();
    }

    @Provides
    @Singleton
    public RecordsPresenter getRecordsPresenter() {
        return new RecordsPresenter();
    }
}
