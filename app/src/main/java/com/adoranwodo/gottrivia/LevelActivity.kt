package com.adoranwodo.gottrivia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.adoranwodo.gottrivia.utils.SharedPreferenceHelper
import kotlinx.android.synthetic.main.activity_level.*

/**
 * Level Activity. View for the three game levels
 * */
class LevelActivity : AppCompatActivity() {

    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        linear_layout_easy.setOnClickListener { loadQuizScreen("Easy") }
        checkButtons()

        btn_close.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }
    }

    @SuppressLint("PrivateResource")
    private fun loadQuizScreen(level: String) {
        val intent = Intent(applicationContext, QuizActivity::class.java)
        intent.putExtra("LEVEL_EXTRA", level)
        startActivity(intent)
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }

    private fun unlockButton(layout: LinearLayout, image: ImageView, level: String) {
        layout.setBackgroundResource(R.drawable.btn_home)
        image.setImageResource(R.drawable.ic_lock_open_white_24dp)
        layout.setOnClickListener { loadQuizScreen(level) }
    }

    private fun checkButtons(){
        val pref = SharedPreferenceHelper(this)
        if(pref.hasUnlockedMedium()){ unlockButton(linear_layout_medium, image_view_medium, "Medium") }
        if(pref.hasUnlockedHard()){ unlockButton(linear_layout_hard, image_view_hard, "Hard") }
    }

    override fun onRestart() {
        super.onRestart()
        checkButtons()
    }

    @SuppressLint("PrivateResource")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }
}
