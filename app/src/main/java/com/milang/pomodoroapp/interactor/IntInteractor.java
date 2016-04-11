package com.milang.pomodoroapp.interactor;

import com.milang.pomodoroapp.model.IntModel;

import javax.inject.Inject;
import com.milang.pomodoroapp.PomodoroApplication;
/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class IntInteractor {
    @Inject
    IntModel model;

    public IntInteractor() {
        PomodoroApplication.injector.inject(this);
    }

    public int getNumber() {
        return model.getNextNum();
    }
}
