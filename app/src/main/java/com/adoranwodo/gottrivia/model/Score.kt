package com.adoranwodo.gottrivia.model

/**
 * Fields for a score
 * */
data class Score(val id: Long = 0,
                 val time: String,
                 val difficulty: String,
                 val points: Int)