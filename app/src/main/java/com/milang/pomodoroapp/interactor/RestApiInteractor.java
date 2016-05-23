package com.milang.pomodoroapp.interactor;

import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.milang.pomodoroapp.network.PomodoroApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class RestApiInteractor {

    @Inject
    PomodoroApi pomodoroApi;

    public RestApiInteractor(){
        PomodoroApplication.injector.inject(this);
    }

    public void addPomodoro(PomodoroTask p) throws Exception {
        Response<PomodoroTask> response = null;
        Call<PomodoroTask> call = pomodoroApi.pomodorotasksPost(p);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }
    }

    public List<PomodoroTask> getGetAllPomodoros() throws Exception {
        Response<List<PomodoroTask>> response = null;
        Call<List<PomodoroTask>> call = pomodoroApi.pomodorotasksAllGet("");
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return response.body();
    }

    public List<PomodoroTask> getGetAllTodo() throws Exception {
        Response<List<PomodoroTask>> response = null;
        Call<List<PomodoroTask>> call = pomodoroApi.pomodorotasksTodoGet("");
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return response.body();
    }

    public List<PomodoroTask> getGetAllActivity() throws Exception {
        Response<List<PomodoroTask>> response = null;
        Call<List<PomodoroTask>> call = pomodoroApi.pomodorotasksActivityGet("");
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return response.body();
    }

    public void delete(PomodoroTask p) throws Exception {
        Response<PomodoroTask> response = null;
        Call<PomodoroTask> call = pomodoroApi.pomodorotasksDelete(p);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }
    }
}
