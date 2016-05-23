package com.milang.pomodoroapp.unittests;

import com.milang.pomodoroapp.BuildConfig;
import com.milang.pomodoroapp.RobolectricDaggerTestRunner;
import com.milang.pomodoroapp.TestHelper;
import com.milang.pomodoroapp.interactor.RestApiInteractor;
import com.milang.pomodoroapp.interactor.SugarOrmInteractor;
import com.milang.pomodoroapp.model.PomodoroTask;
import com.milang.pomodoroapp.network.PomodoroTaskMock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class PomodoroTaskUnitTest {

    @Inject
    RestApiInteractor restApiInteractor;

    @Inject
    SugarOrmInteractor sugarOrmInteractor;

    @Before
    public void setup() throws Exception {
        TestHelper.setTestInjector();
        restApiInteractor = new RestApiInteractor();
        sugarOrmInteractor = new SugarOrmInteractor();
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void mockRestGetAllTest() throws Exception {
        PomodoroTaskMock.resetList();
        if(BuildConfig.FLAVOR == "mock") {
            List<PomodoroTask> list = restApiInteractor.getGetAllPomodoros();
            assertEquals(list.get(1).name, PomodoroTaskMock.testP2.name);
            assertEquals(list.get(2).name, PomodoroTaskMock.testP3.name);
            assertEquals(list.get(0).name, PomodoroTaskMock.testP1.name);
        }
    }

    @Test
    public void mockRestGetAllActivityTest() throws Exception {
        PomodoroTaskMock.resetList();
        if(BuildConfig.FLAVOR == "mock") {
            List<PomodoroTask> list = restApiInteractor.getGetAllActivity();
            assertEquals(list.get(1).name, PomodoroTaskMock.testP2.name);
            assertEquals(list.get(2).name, PomodoroTaskMock.testP3.name);
            assertEquals(list.get(0).name, PomodoroTaskMock.testP1.name);
        }
    }

    @Test
    public void mockRestGetAllTodoTest() throws Exception {
        PomodoroTaskMock.resetList();
        if(BuildConfig.FLAVOR == "mock") {
            List<PomodoroTask> list = restApiInteractor.getGetAllTodo();
            assertEquals(list.get(0).name, PomodoroTaskMock.testP3.name);
            assertEquals(list.size(), 1);
        }
    }

    @Test
    public void mockRestAddTest() throws Exception {
        PomodoroTaskMock.resetList();
        if(BuildConfig.FLAVOR == "mock") {
            PomodoroTask p = new PomodoroTask("name", 1, true);
            restApiInteractor.addPomodoro(p);
            assertEquals(true, PomodoroTaskMock.pomodoroTaskList.contains(p));
        }
    }

    @Test
    public void mockRestDeleteTest() throws Exception {
        PomodoroTaskMock.resetList();
        if(BuildConfig.FLAVOR == "mock") {
            PomodoroTask p = PomodoroTaskMock.testP1;
            restApiInteractor.delete(p);
            assertEquals(false, PomodoroTaskMock.pomodoroTaskList.contains(p));
        }
    }
}