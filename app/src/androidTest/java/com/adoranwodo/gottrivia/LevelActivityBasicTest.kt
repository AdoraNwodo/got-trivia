package com.adoranwodo.gottrivia

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry


import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.rule.ActivityTestRule
import com.adoranwodo.gottrivia.utils.SharedPreferenceHelper
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class LevelActivityBasicTest {

    @get:Rule
    var mActivityTestRule = ActivityTestRule<LevelActivity>(LevelActivity::class.java)

    /**
     * Unlock medium and hard levels before running any test in this class
     * */
    @Before
    fun before(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.unlockMedium()
        pref.unlockHard()
    }

    /**
     * Checks if the quiz intent is launched when the easy button is clicked
     * */
    @Test
    @Throws(Exception::class)
    fun clickEasyButton_LaunchesQuizIntent() {
        // 1. Find the view
        // 2. Perform the action on the view
        Intents.init()
        onView(withId(R.id.linear_layout_easy)).perform(click())

        // 3. Check if the view does what we expected
        intended(hasComponent(QuizActivity::class.java.name))

        Intents.release()
    }

    /**
     * Checks if the quiz intent is launched when the medium button is clicked
     * */
    @Test
    @Throws(Exception::class)
    fun clickMediumButton_LaunchesQuizIntent() {
        Intents.init()
        onView(withId(R.id.linear_layout_medium)).perform(click())
        intended(hasComponent(QuizActivity::class.java.name))
        Intents.release()
    }

    /**
     * Checks if the quiz intent is launched when the hard button is clicked
     * */
    @Test
    @Throws(Exception::class)
    fun clickHardButton_LaunchesQuizIntent() {
        Intents.init()
        onView(withId(R.id.linear_layout_hard)).perform(click())
        intended(hasComponent(QuizActivity::class.java.name))
        Intents.release()
    }
}
