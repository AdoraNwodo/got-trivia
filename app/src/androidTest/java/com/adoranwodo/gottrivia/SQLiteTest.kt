package com.adoranwodo.gottrivia

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adoranwodo.gottrivia.database.QuestionRepository
import com.adoranwodo.gottrivia.database.ScoreRepository
import com.adoranwodo.gottrivia.model.Score


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SQLiteTest {

    /**
     * Attempts to fetch questions for a quiz.
     * The result should have 10 results
     * */
    @Test
    @Throws(Exception::class)
    fun checkThatSQLiteReturnsTenQuestions() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val questions = QuestionRepository(appContext).fetch("Easy")
        assertEquals(questions.size, 10)
    }

    /**
     * Attempts to save score and ensures that action returns long id
     * */
    @Test
    @Throws(Exception::class)
    fun checkThatScoresAreSaved() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val score = ScoreRepository(appContext).create(Score(time = "200s", difficulty = "Easy", points = 30))
        assertTrue(score > 0)   // insertion should return positive long id
    }

    /**
     * Checks that scored can be retrieved.
     * Attempts to save a score and then attempts to fetch all scores.
     * When scores are fetched, there should be at least one score in db
     * */
    @Test
    @Throws(Exception::class)
    fun checkThatScoresCanBeRetrieved() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val scoreRepository = ScoreRepository(appContext)
        // Attempt to add a score
        scoreRepository.create(Score(time = "140s", difficulty = "Easy", points = 70))

        // Now, attempt to fetch all scores. There should be >= 1 scores in the database.
        val scores = scoreRepository.fetch()

        assertTrue(scores.size > 0)
    }
}
