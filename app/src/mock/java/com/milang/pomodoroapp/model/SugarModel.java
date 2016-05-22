package com.milang.pomodoroapp.model;

import com.milang.pomodoroapp.model.PomodoroTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Felix on 4/25/2016.
 */
public class SugarModel {

    private static ArrayList<PomodoroTask> list = new ArrayList<PomodoroTask>();

    private static long idCounter = 1;

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

    public List<PomodoroTask> getPomodoroTasks(){
        ArrayList<PomodoroTask> filterd = new ArrayList<>();
        for (PomodoroTask p: list) {
            if (p.finishedOn == null){
                filterd.add(p);
            }
        }
        return filterd;
    }

    public void createPomodoro(String name, int estimate) {
        PomodoroTask p = new PomodoroTask(name, estimate, true);
        p.setId(idCounter++);
        list.add(p);
    }

    public void plusOnePomodoro(long id) {
        for (PomodoroTask p: list) {
            if (p.getId() == id){
                p.pomodorosDone++;
                return;
            }
        }
    }

    public void deletePomodoro(long id) {
        for (PomodoroTask p: list) {
            if (p.getId() == id){
                list.remove(p);
                return;
            }
        }
    }

    public void addToTodo(long id) {
        for (PomodoroTask p: list) {
            if (p.getId() == id){
                p.isToDoToday = true;
                return;
            }
        }
    }

    public List<PomodoroTask> getToDoTodayTasks() {
        ArrayList<PomodoroTask> filterd = new ArrayList<>();
        for (PomodoroTask p: list) {
            if (p.isToDoToday){
                filterd.add(p);
            }
        }
        return filterd;
    }

    public void removeFromTodo(long id) {
        for (PomodoroTask p: list) {
            if (p.getId() == id){
                p.isToDoToday = false;
                return;
            }
        }
    }

    public List<PomodoroTask> getRecords() {
        ArrayList<PomodoroTask> filterd = new ArrayList<>();
        for (PomodoroTask p: list) {
            if (p.finishedOn != null){
                filterd.add(p);
            }
        }
        return filterd;
    }

    public void finishPomodoro(long id) {
        for (PomodoroTask p: list) {
            if (p.getId()== id){
                p.finishedOn = new Date();
                p.isToDoToday = false;
            }
        }
    }
}
