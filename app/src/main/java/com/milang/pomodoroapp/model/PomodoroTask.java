package com.milang.pomodoroapp.model;

import java.util.Date;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class PomodoroTask {

    public int id;
    public String name;
    public Date createdOn = new Date();
    public Date finishedOn = null;
    public int estimates[] = new int[3];
    public boolean toDoToday = false;

    public PomodoroTask(String name, int firstEstimate){
        estimates[0] = firstEstimate;
        this.name = name;
    }

}
