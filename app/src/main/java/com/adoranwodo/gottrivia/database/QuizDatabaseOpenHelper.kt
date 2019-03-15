package com.adoranwodo.gottrivia.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Helper methods for quiz database
 * */
class QuizDatabaseOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, DATABASE_NAME, null, 1)  {

    companion object {
        //private var ctx: Context? = null

        private var instance: QuizDatabaseOpenHelper? = null

        /**
         * Singletom getInstance method.
         * */
        @Synchronized
        fun getInstance(context: Context): QuizDatabaseOpenHelper {

            if (instance == null){
                instance = QuizDatabaseOpenHelper(context.applicationContext)
            }

            return instance!!
        }
    }

    override fun onCreate(database: SQLiteDatabase?) {
        database?.createTable(QUESTION_TABLE_NAME, true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "question" to TEXT,
            "difficulty" to TEXT,
            "optionA" to TEXT,
            "optionB" to TEXT,
            "optionC" to TEXT,
            "answer" to TEXT )

        database?.createTable(
            SCORE_TABLE_NAME, true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "time" to TEXT,
            "difficulty" to TEXT,
            "points" to INTEGER)

        // add questions onCreate
        for(question in appQuestions) {
            database?.insert(
                QUESTION_TABLE_NAME,
                "question" to question.question,
                "difficulty" to question.difficulty,
                "optionA" to question.optionA,
                "optionB" to question.optionB,
                "optionC" to question.optionC,
                "answer" to question.answer
            )
        }
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        database?.dropTable(QUESTION_TABLE_NAME, ifExists = true)
        database?.dropTable(SCORE_TABLE_NAME, ifExists = true)
        onCreate(database)
    }


}