package com.adoranwodo.gottrivia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        linear_layout_score.setOnClickListener {
            val intent = Intent(applicationContext, ScoresActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }
    }
}
