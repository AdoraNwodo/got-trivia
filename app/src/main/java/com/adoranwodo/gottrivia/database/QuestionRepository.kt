package com.adoranwodo.gottrivia.database

import android.content.Context
import com.adoranwodo.gottrivia.utils.database
import com.adoranwodo.gottrivia.model.Question
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.*

/**
 * Class to fetch and manipulate question data
 * */
class QuestionRepository(val context: Context){

    /**
     * Randomly fetch 10 questions from a particular level
     * @param level difficulty level to fetch
     * */
    fun fetch(level: String?): ArrayList<Question> = context.database.use {
        var questions = ArrayList<Question>()

        select(QUESTION_TABLE_NAME, "id", "question", "difficulty", "optionA", "optionB", "optionC", "answer")
            .whereArgs("difficulty = '$level'")
            .parseList(object: MapRowParser<List<Question>>{
                override fun parseRow(columns: Map<String, Any?>): List<Question>{
                    val id = columns.getValue("id")
                    val question = columns.getValue("question")
                    val difficulty = columns.getValue("difficulty")
                    val optionA = columns.getValue("optionA")
                    val optionB = columns.getValue("optionB")
                    val optionC = columns.getValue("optionC")
                    val answer = columns.getValue("answer")


                    val mQuestion = Question(
                            id.toString().toLong(),
                            question.toString(),
                            difficulty.toString(),
                            optionA.toString(),
                            optionB.toString(),
                            optionC.toString(),
                            answer.toString()
                        )

                    questions.add(mQuestion)

                    return questions
                }

            })
        questions.shuffle()

        ArrayList(questions.take(10))
    }


    /*fun createMulti(questions: ArrayList<Question>) = context.database.use {
        for(question in questions){
            insert(
                QUESTION_TABLE_NAME,
                "question" to question.question,
                "difficulty" to question.difficulty,
                "optionA" to question.optionA,
                "optionB" to question.optionB,
                "optionC" to question.optionC,
                "answer" to question.answer)
        }
    }*/
}