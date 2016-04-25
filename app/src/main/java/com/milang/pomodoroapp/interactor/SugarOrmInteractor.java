package com.milang.pomodoroapp.interactor;

import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.milang.pomodoroapp.model.SugarModel;

import javax.inject.Inject;

/**
 * Created by Felix on 4/25/2016.
 */
public class SugarOrmInteractor {

    @Inject
    SugarModel model;

    public SugarOrmInteractor() {
        PomodoroApplication.injector.inject(this);
    }

    public void saveNewRandomPodomoroTask(){
        model.saveNewRandomPodomoroTask();
    }

    public PomodoroTask getLastPomodoroTask(){
        return model.getLastPomodoroTask();
    }

    public PomodoroTask getFirstPomodoroTask(){
        return model.getFirstPomodoroTask();
    }
}
