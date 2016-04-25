package com.milang.pomodoroapp.interactor;

import javax.inject.Inject;
import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.model.IntModel;

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
