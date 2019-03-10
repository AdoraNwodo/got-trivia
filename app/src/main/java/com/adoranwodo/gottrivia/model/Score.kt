package com.adoranwodo.gottrivia.model

data class Score(val id: Long = 0,
                 val time: String,
                 val difficulty: String,
                 val points: Int)