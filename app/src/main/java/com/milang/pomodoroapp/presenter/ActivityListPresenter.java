package com.milang.pomodoroapp.presenter;

import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.interactor.SugarOrmInteractor;
import com.milang.pomodoroapp.view.fragments.ActivityListView;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class ActivityListPresenter extends Presenter<ActivityListView> {
    @Inject
    public SugarOrmInteractor sugarOrmInteractor;


    public ActivityListPresenter() {
        PomodoroApplication.injector.inject(this);
    }

    public void showActivityList() {

        if (view != null) {
            view.showActivityList(sugarOrmInteractor.getPomodoroTasks());
        }
    }

    public void createPomodoro(String name, int estimate) {
        sugarOrmInteractor.createPomodoro(name, estimate);
        showActivityList();
    }

    public void plusOnePomodoro(long id) {
        sugarOrmInteractor.plusOnePomodoro(id);
        showActivityList();
    }

    public void deletePomodoro(long id) {
        sugarOrmInteractor.deletePomodoro(id);
        showActivityList();
    }

    public void addToTodo(long id) {
        sugarOrmInteractor.addToTodo(id);
        showActivityList();
    }
}
