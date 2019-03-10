package com.adoranwodo.gottrivia.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceHelper(val context: Context) {

    // private val PREFS_NAME = "Adora_GOT_Trivia"

    private val sharedPref: SharedPreferences = context.getSharedPreferences(SharedPreferenceContract.PREF_NAME, Context.MODE_PRIVATE)

    fun isNotFirstInstallation(): Boolean {
        return sharedPref.contains(SharedPreferenceContract.PREF_INSTALLED)
                && sharedPref.getBoolean(SharedPreferenceContract.PREF_INSTALLED, false)
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
     * Get the current highest score of the user
     * @return
     */
    fun getHighestScore(): Int {
        return sharedPref.getInt(SharedPreferenceContract.PREF_HIGHEST_SCORE, 0)
    }

    /**
     * Sets the value of installed to true and unlocks ONLY the easy level.
     */
    fun setFirstInstall() {
        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putBoolean(SharedPreferenceContract.PREF_INSTALLED, true)
        editor.putBoolean(SharedPreferenceContract.PREF_EASY, true)
        editor.putBoolean(SharedPreferenceContract.PREF_MEDIUM, true)
        editor.putBoolean(SharedPreferenceContract.PREF_HARD, true)
        editor.putInt(SharedPreferenceContract.PREF_HIGHEST_SCORE, 0)

        editor.apply()
    }

    /**
     * Checks if a key exists in shared preferences
     * @return
     */
    fun isContainedInSharedPreference(key: String): Boolean {
        return sharedPref.contains(key)
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
     * Sets the highest score
     */
    fun setHighestScore(score: Int) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt(SharedPreferenceContract.PREF_HIGHEST_SCORE, score)
        editor.apply()
    }


    fun save(KEY_NAME: String, status: Boolean) {

        val editor: SharedPreferences.Editor = sharedPref.edit()

        editor.putBoolean(KEY_NAME, status)

        editor.apply()
    }

    fun retrieve(KEY_NAME: String): Boolean {

        return sharedPref.getBoolean(KEY_NAME, false)
    }

    fun clearAll() {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    fun remove(KEY_NAME: String) {

        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.remove(KEY_NAME)
        editor.apply()
    }


}