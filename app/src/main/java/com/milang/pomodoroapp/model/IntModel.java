package com.milang.pomodoroapp.model;

import java.util.Random;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class IntModel {
    public int getNextNum(){
        Random r = new Random();
        return r.nextInt();
    }
}
