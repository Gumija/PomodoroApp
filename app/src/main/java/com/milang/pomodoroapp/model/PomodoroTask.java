package com.milang.pomodoroapp.model;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.Date;
import java.util.Objects;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class PomodoroTask extends SugarRecord {

    @SerializedName("name")
    public String name;

    @SerializedName("user_uuid")
    public String userUuid = null; // uuid = UUID.randomUUID().toString();

    @SerializedName("created_on")
    public Date createdOn = null;

    @SerializedName("finished_on")
    public Date finishedOn = null;

    @SerializedName("estimate1")
    public Integer estimate1 = null;

    @SerializedName("estimate2")
    public Integer estimate2 = null;

    @SerializedName("estimate3")
    public Integer estimate3 = null;

    @SerializedName("is_to_do_today")
    public Boolean isToDoToday = null;

    @SerializedName("pomodoros_done")
    public Integer pomodorosDone = null;

    public PomodoroTask(){

    }

    public PomodoroTask(String name, int firstEstimate, boolean isToDoToday){
        estimate1 = firstEstimate;
        estimate2 = 0;
        estimate3 = 0;
        this.name = name;
        createdOn = new Date();
        finishedOn = null;
        this.isToDoToday = isToDoToday;
        pomodorosDone = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PomodoroTask pomodoroTask = (PomodoroTask) o;
        return Objects.equals(this.getId(), pomodoroTask.getId()) &&
                Objects.equals(userUuid, pomodoroTask.userUuid) &&
                Objects.equals(createdOn, pomodoroTask.createdOn) &&
                Objects.equals(finishedOn, pomodoroTask.finishedOn) &&
                Objects.equals(estimate1, pomodoroTask.estimate1) &&
                Objects.equals(estimate2, pomodoroTask.estimate2) &&
                Objects.equals(estimate3, pomodoroTask.estimate3) &&
                Objects.equals(isToDoToday, pomodoroTask.isToDoToday) &&
                Objects.equals(pomodorosDone, pomodoroTask.pomodorosDone);
    }

}
