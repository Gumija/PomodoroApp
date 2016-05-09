package com.milang.pomodoroapp.network;

import android.net.Uri;

import com.milang.pomodoroapp.model.PomodoroTask;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public class PomodoroTaskMock {

    static List<PomodoroTask> pomodoroTaskList = new ArrayList<>();
    static boolean isInitialised = false;

    public static PomodoroTask testP1 = new PomodoroTask("Network Test 1");
    public static PomodoroTask testP2 = new PomodoroTask("Network Test 2");

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "people") && request.method().equals("GET")) {
            if (!isInitialised) {
                pomodoroTaskList.add(testP1);
                pomodoroTaskList.add(testP2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(pomodoroTaskList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "people/add") && request.method().equals("GET")) {
            int startOfData = uri.getPath().lastIndexOf('/');
            String name = uri.getPath().substring(startOfData + 1);
            pomodoroTaskList.add(new PomodoroTask(name));

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
