package com.milang.pomodoroapp.network;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import io.swagger.client.model.PomodoroTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PomodoroApi {
  
  /**
   * Pomodoro Tasks for a user
   * Returns all of the pomodoro tasks of a user.
   * @param user uuid of the user
   * @return Call<List<PomodoroTask>>
   */
  
  @GET("pomodorotasks")
  Call<List<PomodoroTask>> pomodorotasksGet(
          @Query("user") String user
  );

  
  /**
   * Upload a pomodoro task
   * Upload a pomodoro task to the server. Returns the uploaded task.
   * @param pomodoroTask pomodoro task to upload
   * @return Call<PomodoroTask>
   */
  
  @POST("pomodorotasks")
  Call<PomodoroTask> pomodorotasksPost(
          @Body PomodoroTask pomodoroTask
  );

  
  /**
   * Delete a pomodoro task
   * Delete a pomodoro task to the server. Returns the deleted task.
   * @param pomodoroTask pomodoro task to delete
   * @return Call<PomodoroTask>
   */
  
  @DELETE("pomodorotasks")
  Call<PomodoroTask> pomodorotasksDelete(
          @Body PomodoroTask pomodoroTask
  );

  
  /**
   * Pomodoro Tasks for a user
   * Returns pomodoro tasks from the activity list of a user.
   * @param user uuid of the user
   * @return Call<List<PomodoroTask>>
   */
  
  @GET("pomodorotasks/activity")
  Call<List<PomodoroTask>> pomodorotasksActivityGet(
          @Query("user") String user
  );

  
  /**
   * Pomodoro Tasks for a user
   * Returns all of the pomodoro tasks of a user.
   * @param user uuid of the user
   * @return Call<List<PomodoroTask>>
   */
  
  @GET("pomodorotasks/all")
  Call<List<PomodoroTask>> pomodorotasksAllGet(
          @Query("user") String user
  );

  
  /**
   * Pomodoro Tasks for a user
   * Returns pomodoro tasks from the todo list of a user.
   * @param user uuid of the user
   * @return Call<List<PomodoroTask>>
   */
  
  @GET("pomodorotasks/todo")
  Call<List<PomodoroTask>> pomodorotasksTodoGet(
          @Query("user") String user
  );

  
}
