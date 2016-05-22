package com.milang.pomodoroapp;

import com.milang.pomodoroapp.interactor.SugarOrmInteractor;
import com.milang.pomodoroapp.presenter.ActivityListPresenter;
import com.milang.pomodoroapp.presenter.MainPresenter;
import com.milang.pomodoroapp.view.MainActivity;
import com.milang.pomodoroapp.view.fragments.ActivityListFragment;
import com.milang.pomodoroapp.view.fragments.RecordsFragment;
import com.milang.pomodoroapp.view.fragments.ToDoTodayFragment;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public interface MainComponent {

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(ActivityListPresenter activityListPresenter);

    void inject(ActivityListFragment activityListFragment);

    void inject(ToDoTodayFragment toDoTodayFragment);

    void inject(RecordsFragment recordsFragment);

    void inject(SugarOrmInteractor sugarOrmInteractor);

    void inject(PomodoroApplication app);

//    void inject(IntInteractor intInteractor);
}
