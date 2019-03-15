package com.adoranwodo.gottrivia

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4


import org.junit.Test
import org.junit.runner.RunWith

import androidx.test.rule.ActivityTestRule
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityBasicTest {

    @get:Rule
    var mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    /**
     * Checks if the level intent is launched when the play button is clicked
     * */
    @Test
    @Throws(Exception::class)
    fun clickPlayButton_LaunchesLevelIntent() {
        // 1. Find the view
        // 2. Perform the action on the view
        Intents.init()
        onView(withId(R.id.btn_play)).perform(click())

        // 3. Check if the view does what we expected
        intended(hasComponent(LevelActivity::class.java.name))

        Intents.release()
    }

    /**
     * Checks if the score intent is launched when the score button is clicked
     * */
    @Test
    @Throws(Exception::class)
    fun clickScoreButton_LaunchesScoreIntent() {
        // 1. Find the view
        // 2. Perform the action on the view
        Intents.init()
        onView(withId(R.id.linear_layout_score)).perform(click())

        // 3. Check if the view does what we expected
        intended(hasComponent(ScoresActivity::class.java.name))

        Intents.release()
    }

    /**
     * Checks if the rules intent is launched when the rules button is clicked
     * */
    @Test
    @Throws(Exception::class)
    fun clickRulesButton_LaunchesRulesIntent() {
        // 1. Find the view
        // 2. Perform the action on the view
        Intents.init()
        onView(withId(R.id.linear_layout_rules)).perform(click())

        // 3. Check if the view does what we expected
        intended(hasComponent(RulesActivity::class.java.name))

        Intents.release()
    }

}
