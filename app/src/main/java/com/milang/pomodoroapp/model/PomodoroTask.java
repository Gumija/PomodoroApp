package com.milang.pomodoroapp.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class PomodoroTask extends SugarRecord {

    public String name;
    public Date createdOn;
    public Date finishedOn;
    public int estimate1;
    public int estimate2;
    public int estimate3;
    public boolean toDoToday;

    public PomodoroTask(){

    }

    public PomodoroTask(String name, int firstEstimate, boolean toDoToday){
        estimate1 = firstEstimate;
        estimate2 = 0;
        estimate3 = 0;
        this.name = name;
        createdOn = new Date();
        finishedOn = null;
        this.toDoToday = toDoToday;
    }

}
