package com.mtomoskozi.sugarapp;

import android.content.Context;

import com.mtomoskozi.sugarapp.interactor.InteractorModule;
import com.mtomoskozi.sugarapp.model.prod.ModelModule;
import com.mtomoskozi.sugarapp.model.prod.PeopleDbModel;
import com.mtomoskozi.sugarapp.presenter.MainPresenter;
import com.mtomoskozi.sugarapp.view.ViewModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Máté on 02/05/2016.
 */
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
    public PeopleDbModel provideLoginPresenter() {
        return modelModule.providePeopleDbModel();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return viewModule.provideMainPresenter();
    }
}
