package com.milang.pomodoroapp.model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

/**
 * Created by Felix on 4/25/2016.
 */
public class SugarModel {

    public void saveNewRandomPodomoroTask(){
        int name = ThreadLocalRandom.current().nextInt();
        PomodoroTask p = new PomodoroTask("name_" + String.valueOf(name), ThreadLocalRandom.current().nextInt(1,10),false);
        p.save();
    }

    public PomodoroTask getLastPomodoroTask(){
        return PomodoroTask.find(PomodoroTask.class,null,null,null,"id DESC","1").get(0);
    }

    public PomodoroTask getFirstPomodoroTask(){
        return PomodoroTask.find(PomodoroTask.class,null,null,null,"id ASC","1").get(0);
    }

    public List<PomodoroTask> getPomodoroTasks(){
        return PomodoroTask.listAll(PomodoroTask.class);
    }
}
