package com.adoranwodo.gottrivia.database

import android.content.Context
import com.adoranwodo.gottrivia.utils.database
import com.adoranwodo.gottrivia.model.Score
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class ScoreRepository(val context: Context){


    fun create(score: Score) = context.database.use {
        insert(
            SCORE_TABLE_NAME,
            "time" to score.time,
            "difficulty" to score.difficulty,
            "points" to score.points )
    }

    fun fetch(): ArrayList<Score> = context.database.use {
        var scores = ArrayList<Score>()

        select(SCORE_TABLE_NAME, "id", "time", "difficulty", "points")
            .parseList(object: MapRowParser<List<Score>> {
                override fun parseRow(columns: Map<String, Any?>): List<Score>{
                    val id = columns.getValue("id")
                    val time = columns.getValue("time")
                    val difficulty = columns.getValue("difficulty")
                    val points = columns.getValue("points")


                    val score = Score(
                        id.toString().toLong(),
                        time.toString(),
                        difficulty.toString(),
                        points.toString().toInt()
                    )

                    scores.add(score)

                    return scores
                }
            })
        scores
    }

}