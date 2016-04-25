package com.milang.pomodoroapp.model;

import com.milang.pomodoroapp.model.PomodoroTask;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Felix on 4/25/2016.
 */
public class SugarModel {

    private static ArrayList<PomodoroTask> list = new ArrayList<PomodoroTask>();

    public void saveNewRandomPodomoroTask(){
        int name = ThreadLocalRandom.current().nextInt();
        PomodoroTask p = new PomodoroTask("name_" + String.valueOf(name), ThreadLocalRandom.current().nextInt(1,10),false);
        list.add(p);
    }

    public PomodoroTask getLastPomodoroTask(){
        return list.get(list.size()-1);
    }

    public PomodoroTask getFirstPomodoroTask(){
        return list.get(0);
    }
}
