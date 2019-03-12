package com.adoranwodo.gottrivia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ShareActionProvider
import com.adoranwodo.gottrivia.database.ScoreRepository
import com.adoranwodo.gottrivia.model.Score
import com.adoranwodo.gottrivia.utils.SharedPreferenceHelper
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private var timeRemaining: Long = 0
    private var score = 0
    private var level = ""
    private var levelTotalTime: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val pref = SharedPreferenceHelper(this)

        val bundle = intent.extras

        if (bundle == null) {
            finish()
        }

        timeRemaining = bundle.getLong("TIME_REMAINING_EXTRA")
        score = bundle.getInt("SCORE_EXTRA")
        levelTotalTime = bundle.getLong("AVAILABLE_TIME_EXTRA")
        level = bundle.getString("LEVEL_EXTRA")

        val timeElapsedInSeconds = (levelTotalTime - timeRemaining) / 1000


        // store game score
        ScoreRepository(this).create(Score( time = "${timeElapsedInSeconds}s", difficulty = level, points = score ))

        text_total_score.text = "Your Score: $score"
        if(score > 140 && ! pref.hasUnlockedHard()){
            text_game_over.text = getString(R.string.text_you_unlocked_hard)
            pref.unlockHard()
        }else if(score > 70 && ! pref.hasUnlockedMedium()){
            text_game_over.text = getString(R.string.text_you_unlocked_medium)
            pref.unlockMedium()
        }


        linear_layout_score.setOnClickListener { goToScore() }
        linear_layout_share.setOnClickListener { launchShareIntent() }
        btn_start_new_game.setOnClickListener { finish() }

    }

    private fun goToScore() {
        val intent = Intent(applicationContext, ScoresActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }

    private fun launchShareIntent() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "I played Adora's Game of Thrones Trivia quiz and I scored $score. Think you can beat mine, play to find out!")
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "I played Adora's GOT Trivia")
        startActivity(Intent.createChooser(shareIntent, "Share results via"))
    }
}
