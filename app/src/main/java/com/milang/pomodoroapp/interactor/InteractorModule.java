package com.milang.pomodoroapp.interactor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
@Module
public class InteractorModule {

    @Provides
    public IntInteractor getIntInteractor() {
        return new IntInteractor();
    }
}
