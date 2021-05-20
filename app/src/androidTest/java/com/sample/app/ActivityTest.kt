package com.sample.app

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import androidx.test.espresso.action.ViewActions.click

@RunWith(AndroidJUnit4::class)
class ActivityTest : KoinTest {

    @Test
    fun isActivity() {
        val activity = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.item_text)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerListExampleButton)).check(matches(isDisplayed()))
        onView(withId(R.id.messageText)).check(matches(isDisplayed()))
    }

    @Test
    fun navToSecondActivity() {
        val activity = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.recyclerListExampleButton)).perform(click())
        onView(withId(R.id.frame)).check(matches(isDisplayed()))
    }

    fun navBack() {
        val activity = ActivityScenario.launch(MainActivity::class.java)
        pressBack()
        onView(withId(R.id.frame)).check(matches(isDisplayed()))
    }
}