package com.adoranwodo.gottrivia.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Helpers to fetch and edit sharedp preferences
 * */
class SharedPreferenceHelper(val context: Context) {

    private val sharedPref: SharedPreferences = context.getSharedPreferences(SharedPreferenceContract.PREF_NAME, Context.MODE_PRIVATE)

    /**
     * Checks if user has installed the application before
     * @return
     */
    fun isFirstInstallation(): Boolean {
        return ! (sharedPref.contains(SharedPreferenceContract.PREF_INSTALLED)
                && sharedPref.getBoolean(SharedPreferenceContract.PREF_INSTALLED, false))
    }

    /**
     * Check that user has unlocked the medium level
     * @return
     */
    fun hasUnlockedMedium(): Boolean {
        return sharedPref.getBoolean(SharedPreferenceContract.PREF_MEDIUM, false)
    }

    /**
     * Check that user has unlocked the hard level
     * @return
     */
    fun hasUnlockedHard(): Boolean {
        return sharedPref.getBoolean(SharedPreferenceContract.PREF_HARD, false)
    }

    /**
     * Sets the value of installed to true and unlocks ONLY the easy level.
     */
    fun setFirstInstall() {
        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putBoolean(SharedPreferenceContract.PREF_INSTALLED, true)
        editor.putBoolean(SharedPreferenceContract.PREF_EASY, true)
        editor.putBoolean(SharedPreferenceContract.PREF_MEDIUM, false)
        editor.putBoolean(SharedPreferenceContract.PREF_HARD, false)
        editor.putInt(SharedPreferenceContract.PREF_HIGHEST_SCORE, 0)

        editor.apply()
    }

    /**
     * Sets the value of medium to true
     */
    fun unlockMedium() {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(SharedPreferenceContract.PREF_MEDIUM, true)
        editor.apply()
    }

    /**
     * Sets the value of hard to true
     */
    fun unlockHard() {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(SharedPreferenceContract.PREF_HARD, true)
        editor.apply()
    }

    /**
     * Removes all items from Shared Preference file
     */
    fun clearAll() {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }
}