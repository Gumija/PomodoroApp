package com.milang.pomodoroapp.presenter;

import javax.inject.Inject;
import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.interactor.IntInteractor;
import com.milang.pomodoroapp.interactor.SugarOrmInteractor;
import com.milang.pomodoroapp.view.MainView;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class MainPresenter extends Presenter<MainView> {

    @Inject
    public IntInteractor interactor;

    @Inject
    public SugarOrmInteractor sugarOrmInteractor;

    public MainPresenter() {
        PomodoroApplication.injector.inject(this);
    }

    public void doStuff() {
        view.showNumber(interactor.getNumber());
    }

    public void showFirstPomodoroTaskName(){
        view.showPomodoroTaskName(sugarOrmInteractor.getFirstPomodoroTask());
    }

    public void showLastPomodoroTaskName(){
        view.showPomodoroTaskName(sugarOrmInteractor.getLastPomodoroTask());
    }

    public void addNewPomodoro(){
        sugarOrmInteractor.saveNewRandomPodomoroTask();
    }
}
