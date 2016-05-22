package com.milang.pomodoroapp.presenter;

import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.interactor.SugarOrmInteractor;
import com.milang.pomodoroapp.view.fragments.ActivityListFragment;
import com.milang.pomodoroapp.view.fragments.ToDoTodayView;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class ToDoTodayPresenter extends Presenter<ToDoTodayView> {

    @Inject
    public SugarOrmInteractor sugarOrmInteractor;

    public ToDoTodayPresenter() {
        PomodoroApplication.injector.inject(this);
    }

    public void showToDoTodayList() {
        if (view != null) {
            view.showToDoTodayList(sugarOrmInteractor.getToDoTodayTasks());
        }
    }

    public void plusOnePomodoro(long id) {
        sugarOrmInteractor.plusOnePomodoro(id);
        showToDoTodayList();
    }

    public void deletePomodoro(long id) {
        sugarOrmInteractor.deletePomodoro(id);
        showToDoTodayList();
    }

    public void removeFromTodo(long id) {
        sugarOrmInteractor.removeFromTodo(id);
        showToDoTodayList();
    }

    public void finishPomodoro(long id) {
        sugarOrmInteractor.finishPomodoro(id);
        showToDoTodayList();
    }
}
