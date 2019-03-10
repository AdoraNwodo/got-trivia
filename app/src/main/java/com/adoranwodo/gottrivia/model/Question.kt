package com.adoranwodo.gottrivia.model

data class Question(
    val id: Long = 0,
    val question: String,
    val difficulty: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val answer: String )