package com.adoranwodo.gottrivia

import android.content.Context
import com.adoranwodo.gottrivia.database.QuizDatabaseOpenHelper

val Context.database: QuizDatabaseOpenHelper
    get() = QuizDatabaseOpenHelper.getInstance(applicationContext)