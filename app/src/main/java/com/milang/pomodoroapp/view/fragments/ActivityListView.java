package com.milang.pomodoroapp.view.fragments;

import com.milang.pomodoroapp.model.PomodoroTask;

import java.util.List;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public interface ActivityListView {

    void showActivityList(List<PomodoroTask> pomodoroTaskList);

    void scrollToActivityItem(PomodoroTask pomodoroTask);
}
