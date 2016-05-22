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
        view.showActivityList(sugarOrmInteractor.getPomodoroTasks());
    }
}
