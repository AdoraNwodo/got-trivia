package com.adoranwodo.gottrivia.model

import android.os.Parcelable
import java.util.*


data class Question(
    val id: Long,
    val question: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val answer: String )