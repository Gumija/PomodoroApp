package com.milang.pomodoroapp.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.R;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.milang.pomodoroapp.presenter.ActivityListPresenter;
import com.milang.pomodoroapp.presenter.ToDoTodayPresenter;
import com.milang.pomodoroapp.view.adapters.PomodoroListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class ToDoTodayFragment extends ListFragment implements ToDoTodayView, PomodoroListAdapter.PomodoroListAdapterListener {

    @Inject
    ToDoTodayPresenter toDoTodayPresenter;

    public ToDoTodayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        PomodoroApplication.injector.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_today, container, false);
    }

    @Override
    public void showToDoTodayList(List<PomodoroTask> pomodoroTaskList) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> estimates = new ArrayList<>();
        ArrayList<Integer> dones = new ArrayList<>();
        ArrayList<Long> ids = new ArrayList<>();
        for(PomodoroTask p : pomodoroTaskList){
            names.add(p.name);
            estimates.add(p.estimate1);
            dones.add(p.pomodorosDone);
            ids.add(p.getId());
        }

        PomodoroListAdapter pla = new PomodoroListAdapter(getActivity(),
                names.toArray(new String[0]),
                dones.toArray(new Integer[0]),
                estimates.toArray(new Integer[0]),
                ids.toArray(new Long[0]),
                true
        );
        pla.attachListener(this);

        setListAdapter(pla);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        toDoTodayPresenter.attachView(this);
        toDoTodayPresenter.showToDoTodayList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toDoTodayPresenter.detachView();
    }

    @Override
    public void plusOne(long id) {
        toDoTodayPresenter.plusOnePomodoro(id);
    }

    @Override
    public void delete(long id) {
        toDoTodayPresenter.deletePomodoro(id);
    }

    @Override
    public void move(long id) {
        toDoTodayPresenter.removeFromTodo(id);
    }

    @Override
    public void finish(long id) {
        toDoTodayPresenter.finishPomodoro(id);
    }
}
