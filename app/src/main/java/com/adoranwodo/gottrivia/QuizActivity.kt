package com.adoranwodo.gottrivia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.adoranwodo.gottrivia.database.QuestionRepository
import com.adoranwodo.gottrivia.model.Question
import kotlinx.android.synthetic.main.activity_quiz.*
import android.os.CountDownTimer
import java.util.*
import java.util.concurrent.TimeUnit


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class QuizActivity : AppCompatActivity() {

    private var questions = ArrayList<Question>()
    private var scoreIncrement = 0
    private var levelTotalTime: Long = 0
    private var timeRemaining: Long = 0
    private val countDownInterval: Long = 1000
    private var score = 0
    private var questionId = 0
    private var currentQuestion: Question? = null
    private var level: String? = "Easy"

    @SuppressLint("PrivateResource, SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val bundle = intent.extras

        if (bundle == null) {
            finish()
        }

        level = bundle.getString("LEVEL_EXTRA")

        questions = QuestionRepository(this).fetch(level)
        currentQuestion = questions[questionId]

        // set quiz time
        when(level){
            "Easy" -> {
                text_view_time_left.text = "Time left - 00:04:00"
                levelTotalTime =  240000 // 300000
                scoreIncrement = 10
            }
            "Medium" -> {
                text_view_time_left.text = "Time left - 00:02:00"
                levelTotalTime = 120000
                scoreIncrement = 20
            }
            "Hard" -> {
                text_view_time_left.text = "Time left - 00:01:00"
                levelTotalTime = 60000
                scoreIncrement = 30
            }
        }

        setQuestionView()

        btn_close.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }

        setTimer(levelTotalTime)

        button_option_a.setOnClickListener { answerEvaluator(button_option_a) }
        button_option_b.setOnClickListener { answerEvaluator(button_option_b) }
        button_option_c.setOnClickListener { answerEvaluator(button_option_c) }
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestionView(){
        text_view_questions_answered.text = "${questionId + 1} / ${questions.size}"
        text_view_question.text = currentQuestion?.question
        button_option_a.text = currentQuestion?.optionA
        button_option_b.text = currentQuestion?.optionB
        button_option_c.text = currentQuestion?.optionC

        questionId++
    }

    private fun answerEvaluator(button: Button) {
        val answer = checkAnswer(button.text.toString())

        if(answer) button.setBackgroundResource(R.drawable.btn_correct)
            else button.setBackgroundResource(R.drawable.btn_wrong)

        val handler = Handler()
        handler.postDelayed({
            button.setBackgroundResource(R.drawable.btn_default)
            goToNextQuestion()
        }, 300)

    }

    @SuppressLint("SetTextI18n")
    private fun checkAnswer(answer: String): Boolean {
        if(currentQuestion?.answer.equals(answer)){
            score += scoreIncrement
            text_view_default_score.text = "Score: $score"
            return true
        }
        return false
    }

    private fun goToNextQuestion() {
        if(questionId < questions.size){
            currentQuestion = questions[questionId]
            setQuestionView()
        }else{
            toResultsPage()
        }
    }

    @SuppressLint("PrivateResource")
    fun toResultsPage(){
        val intent = Intent(applicationContext, ResultActivity::class.java)
        intent.putExtra("TIME_REMAINING_EXTRA", timeRemaining)
        intent.putExtra("SCORE_EXTRA", score)
        intent.putExtra("AVAILABLE_TIME_EXTRA", levelTotalTime)
        intent.putExtra("LEVEL_EXTRA", level)
        startActivity(intent)
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        finish()
    }

    @SuppressLint("SetTextI18n")
    private fun setTimer(time: Long){
        val millisInFuture: Long = time

        object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {

                //Display the remaining seconds to the app interface
                //1 second = 1000 milliseconds
                val hms = String.format(
                    Locale.ENGLISH, "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(
                            millisUntilFinished
                        )
                    ),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(
                            millisUntilFinished
                        )
                    )
                )
                if (millisUntilFinished / 1000 < 10) {
                    text_view_time_left.setBackgroundResource(R.drawable.bg_time_warn)
                }
                text_view_time_left.text = "Time left - $hms"
                timeRemaining = millisUntilFinished

            }

            override fun onFinish() {
                toResultsPage()
            }
        }.start()
    }

    @SuppressLint("PrivateResource")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }
}

