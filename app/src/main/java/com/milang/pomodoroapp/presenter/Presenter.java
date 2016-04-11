package com.milang.pomodoroapp.presenter;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public abstract class Presenter<S> {
    protected S view;

    public void attachView(S screen){
        this.view = screen;
    }

    public void detachView(){
        this.view = null;
    }
}
