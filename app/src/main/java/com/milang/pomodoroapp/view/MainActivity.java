package com.milang.pomodoroapp.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import com.milang.pomodoroapp.PomodoroApplication;

import com.milang.pomodoroapp.R;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.milang.pomodoroapp.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PomodoroApplication.injector.inject(this);

        TextView tv = ((TextView)findViewById(R.id.tvNumber));
        tv.setText("Hi Mom !!!");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You little cheesy programmer...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showNumber(int num) {
        TextView tv = ((TextView)findViewById(R.id.tvNumber));
        tv.setText(String.format("%1$d", num));
    }

    @Override
    public void showPomodoroTaskName(PomodoroTask pomodoroTask) {
        TextView tv = ((TextView)findViewById(R.id.tvNumber));
        tv.setText(pomodoroTask.name);
    }

    public void buttonClicked(View view){
        mainPresenter.doStuff();
    }

    public void buttonFirstClicked(View view) {
        mainPresenter.showFirstPomodoroTaskName();
    }

    public void buttonLastClicked(View view) {
        mainPresenter.showLastPomodoroTaskName();
    }

    public void buttonNewClicked(View view) {
        mainPresenter.addNewPomodoro();
    }
}
