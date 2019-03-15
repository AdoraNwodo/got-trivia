package com.adoranwodo.gottrivia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_scores.*

/**
 * View to show the game rules
 * */
class RulesActivity : AppCompatActivity() {

    @SuppressLint("PrivateResource")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        btn_close.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }
    }

    @SuppressLint("PrivateResource")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }
}
