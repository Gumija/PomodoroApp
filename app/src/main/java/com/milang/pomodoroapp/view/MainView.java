package com.milang.pomodoroapp.view;

import com.milang.pomodoroapp.model.PomodoroTask;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public interface MainView {
    void showNumber(int num);

    void showPomodoroTaskName(PomodoroTask pomodoroTask);
}
