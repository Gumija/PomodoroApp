package com.milang.pomodoroapp.presenter;

import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.interactor.SugarOrmInteractor;
import com.milang.pomodoroapp.view.fragments.RecordsView;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class RecordsPresenter extends Presenter<RecordsView> {

    @Inject
    public SugarOrmInteractor sugarOrmInteractor;

    public RecordsPresenter(){
        PomodoroApplication.injector.inject(this);
    }

    public void showRecordsList() {
        if (view != null) {
            view.showRecordsList(sugarOrmInteractor.getRecords());
        }
    }
}
