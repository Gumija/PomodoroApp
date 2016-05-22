package com.milang.pomodoroapp.network;

import android.net.Uri;

import com.google.gson.Gson;
import com.milang.pomodoroapp.model.PomodoroTask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public class PomodoroTaskMock {

    static List<PomodoroTask> pomodoroTaskList = new ArrayList<>();

    static boolean isInitialised = false;

    public static PomodoroTask testP1 = new PomodoroTask("p1",3,false);
    public static PomodoroTask testP2 = new PomodoroTask("p2",4,false);
    public static PomodoroTask testP3 = new PomodoroTask("p3",5,true);

    private static List<PomodoroTask> getTodoList(){
        List<PomodoroTask> pl = new ArrayList<PomodoroTask>();
        for (PomodoroTask p : pomodoroTaskList) {
            if(p.isToDoToday){
                pl.add(p);
            }
        }
        return pl;
    }

    private static List<PomodoroTask> getActivityList(){
        List<PomodoroTask> pl = new ArrayList<PomodoroTask>();
        for (PomodoroTask p : pomodoroTaskList) {
            if(p.finishedOn == null){
                pl.add(p);
            }
        }
        return pl;
    }

    private static void removeIfContains(PomodoroTask p){
        for (PomodoroTask pt : pomodoroTaskList) {
            if(p.getId() == pt.getId()){
                pomodoroTaskList.remove(p);
                return;
            }
        }
    }

    private static void addOrUpdate(PomodoroTask p){
        for (PomodoroTask pt : pomodoroTaskList) {
            if(p.getId() == pt.getId()){
                pt.userUuid = p.userUuid;
                pt.estimate1 = p.estimate1;
                pt.estimate2 = p.estimate2;
                pt.estimate3 = p.estimate3;
                pt.name = p.name;
                pt.createdOn = p.createdOn;
                pt.finishedOn = p.finishedOn;
                pt.isToDoToday = p.isToDoToday;
                pt.pomodorosDone = p.pomodorosDone;
                return;
            }
        }
    }

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (!isInitialised) {
            pomodoroTaskList.add(testP1);
            pomodoroTaskList.add(testP2);
            pomodoroTaskList.add(testP3);

            isInitialised = true;
        }

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "pomodorotasks/all") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(pomodoroTaskList);
            responseCode = 200;
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "pomodorotasks/todo") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(getTodoList());
            responseCode = 200;
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "pomodorotasks/activity") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(getActivityList());
            responseCode = 200;
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "pomodorotasks") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(pomodoroTaskList);
            responseCode = 200;
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "pomodorotasks") && request.method().equals("POST")) {
            PomodoroTask p = GsonHelper.getGson().fromJson(request.body().toString(), PomodoroTask.class);
            addOrUpdate(p);
            responseString = "";
            responseCode = 200;
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "pomodorotasks") && request.method().equals("DELETE")) {
            PomodoroTask p = GsonHelper.getGson().fromJson(request.body().toString(), PomodoroTask.class);
            removeIfContains(p);
            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        pomodoroTaskList.clear();
        isInitialised = false;
    }
}
