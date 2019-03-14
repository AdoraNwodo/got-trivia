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

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.adoranwodo.gottrivia", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun checkFirstInstallation() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.clearAll() // clear previous preferences
        assertTrue(pref.isFirstInstallation())
    }

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

    @Test
    @Throws(Exception::class)
    fun checkUnlockMedium() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.unlockMedium()
        assertTrue(pref.hasUnlockedMedium())
    }

    @Test
    @Throws(Exception::class)
    fun checkUnlockHard() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val pref = SharedPreferenceHelper(appContext)
        pref.unlockHard()
        assertTrue(pref.hasUnlockedHard())
    }

}
