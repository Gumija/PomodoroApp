package com.mtomoskozi.sugarapp;

import com.mtomoskozi.sugarapp.android.SugarAppApplicationComponent;
import com.mtomoskozi.sugarapp.interactor.InteractorModule;
import com.mtomoskozi.sugarapp.network.mock.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Máté on 02/05/2016.
 */
@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends SugarAppApplicationComponent {
}
