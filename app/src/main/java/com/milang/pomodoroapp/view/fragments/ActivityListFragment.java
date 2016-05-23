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

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.milang.pomodoroapp.PomodoroApplication;
import com.milang.pomodoroapp.R;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.milang.pomodoroapp.presenter.ActivityListPresenter;
import com.milang.pomodoroapp.view.adapters.PomodoroListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivityListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityListFragment extends ListFragment implements ActivityListView, PomodoroListAdapter.PomodoroListAdapterListener {

    @Inject
    ActivityListPresenter activityListPresenter;


    public ActivityListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Obtain the shared Tracker instance.
        PomodoroApplication.injector.inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity_list, container, false);
    }

    @Override
    public void showActivityList(List<PomodoroTask> pomodoroTaskList) {
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
                false
        );
        pla.attachListener(this);

        setListAdapter(pla);
    }

    @Override
    public void scrollToActivityItem(PomodoroTask pomodoroTask) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        activityListPresenter.attachView(this);
        activityListPresenter.showActivityList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activityListPresenter.detachView();
    }

    @Override
    public void plusOne(long id) {
        activityListPresenter.plusOnePomodoro(id);
    }

    @Override
    public void delete(long id) {
        activityListPresenter.deletePomodoro(id);
    }

    @Override
    public void move(long id) {
        activityListPresenter.addToTodo(id);
    }

    @Override
    public void finish(long id) {

    }
}
