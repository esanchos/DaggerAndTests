package com.earaujo.doingtests

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    val mainActivity = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.earaujo.doingtests", appContext.packageName)
    }

    @Test
    fun hasTheText() {
        onView(withId(R.id.tvOutput)).check(matches(withText("Hello World!")))
    }

    @Test
    fun mirrorTheText() {
        onView(withId(R.id.etInput)).perform(typeText("Eduardo"))
        closeSoftKeyboard()
        onView(withId(R.id.btnGo)).perform(click())
        onView(withId(R.id.tvOutput)).check(matches(withText("Eduardo")))
    }
}
