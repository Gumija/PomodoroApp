package com.milang.pomodoroapp.UITest;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.media.MediaMetadataCompat;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import com.milang.pomodoroapp.R;
import com.milang.pomodoroapp.view.MainActivity;
import com.milang.pomodoroapp.view.TabsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {

    @Rule
    public ActivityRule<TabsActivity> mActivityRule = new ActivityRule(TabsActivity.class);

    @Test
    public void ActivityToTodo(){
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.todo_fragment)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void ActivityToRecords(){
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.container)).perform(swipeLeft());
        onView(withId(R.id.records_fragment)).check(ViewAssertions.matches(isDisplayed()));
    }

    @Test
    public void displayDialog(){
        onView(withId(R.id.add_pomodoro)).perform(click());
        onView(withId(R.id.add_dialog_fragment)).check(ViewAssertions.matches(isDisplayed()));
    }
}
