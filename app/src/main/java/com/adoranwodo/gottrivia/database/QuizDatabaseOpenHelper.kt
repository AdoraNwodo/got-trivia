package com.adoranwodo.gottrivia.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class QuizDatabaseOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, DATABASE_NAME, null, 1)  {

    companion object {
        private var instance: QuizDatabaseOpenHelper? = null

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
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        database?.dropTable(QUESTION_TABLE_NAME, ifExists = true)
        database?.dropTable(SCORE_TABLE_NAME, ifExists = true)
        onCreate(database)
    }
}