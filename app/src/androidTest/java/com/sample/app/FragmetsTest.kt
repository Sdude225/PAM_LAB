package com.sample.app

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sample.app.fragments.AccountFragment
import com.sample.app.fragments.CourseFragment
import com.sample.app.fragments.HomeFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmetsTest {
    @Test
    fun testAccountFragment()
    {
        val fragment = launchFragmentInContainer<AccountFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.imageView)).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testCourseFragment()
    {
        val fragment = launchFragmentInContainer<CourseFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.item_horizontal_list)).check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.vertical_list)).check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bottom_nav)).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testHomeFragment()
    {
        val fragment = launchFragmentInContainer<HomeFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.courses)).check(matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.bottom_nav)).check(matches(ViewMatchers.isDisplayed()))
    }
}
