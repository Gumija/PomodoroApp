package com.milang.pomodoroapp;

import com.milang.pomodoroapp.interactor.IntInteractor;

public interface FlavorComponent extends MainComponent{

    void inject(IntInteractor mockIntInteractor);
}