package com.milang.pomodoroapp.view;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.milang.pomodoroapp.presenter.MainPresenter;
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
}
