package com.milang.pomodoroapp.view.fragments;

import com.milang.pomodoroapp.model.PomodoroTask;

import java.util.List;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public interface RecordsView {

    void showRecordsList(List<PomodoroTask> pomodoroTasks);
}
