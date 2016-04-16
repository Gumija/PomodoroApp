package com.milang.pomodoroapp.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class IntModel {
    public int getNextNum(){
        return ThreadLocalRandom.current().nextInt(0, 100+1);
    }
}
