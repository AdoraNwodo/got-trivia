package com.adoranwodo.gottrivia

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import com.adoranwodo.gottrivia.utils.SharedPreferenceHelper


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SharedPrefTest {

    /**
     * Checks the context of the app under test
     * */
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.adoranwodo.gottrivia", appContext.packageName)
    }

    /**
     * Attempts to clear shared prefs and checks that app appears to be installed for the first time
     * */
    @Test
    @Throws(Exception::class)
    fun checkFirstInstallation() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.clearAll() // clear previous preferences
        assertTrue(pref.isFirstInstallation())
    }

    /**
     * Checks that after setting that app has been installed in preferences, the medium and hard levels are locked
     * */
    @Test
    @Throws(Exception::class)
    fun checkFirstInstallationSet() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.setFirstInstall()
        assertTrue(! pref.isFirstInstallation())
        assertFalse(pref.hasUnlockedMedium())
        assertFalse(pref.hasUnlockedHard())
    }

    /**
     * Attempts to unlock the medium level and makes sure it actually unlocks
     * */
    @Test
    @Throws(Exception::class)
    fun checkUnlockMedium() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.unlockMedium()
        assertTrue(pref.hasUnlockedMedium())
    }

    /**
     * Attempts to unlock the hard level and makes sure it actually unlocks
     * */
    @Test
    @Throws(Exception::class)
    fun checkUnlockHard() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.unlockHard()
        assertTrue(pref.hasUnlockedHard())
    }

}
