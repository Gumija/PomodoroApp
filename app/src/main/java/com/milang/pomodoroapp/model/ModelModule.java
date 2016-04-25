package com.milang.pomodoroapp.model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
@Module
public class ModelModule {
    @Provides
    public IntModel getIntModel(){ return new IntModel(); }

    @Provides
    public SugarModel getSugarModel(){ return new SugarModel(); }
}
