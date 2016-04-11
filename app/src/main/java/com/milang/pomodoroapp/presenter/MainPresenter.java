package com.milang.pomodoroapp.presenter;

import com.milang.pomodoroapp.interactor.IntInteractor;

import javax.inject.Inject;
import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.view.MainView;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class MainPresenter extends Presenter<MainView> {

    @Inject
    public IntInteractor interactor;

    public MainPresenter() {
        PomodoroApplication.injector.inject(this);
    }

    public void doStuff() {
        view.showNumber(interactor.getNumber());
    }
}
