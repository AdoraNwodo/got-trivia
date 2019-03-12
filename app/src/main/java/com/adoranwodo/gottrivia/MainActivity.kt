package com.adoranwodo.gottrivia

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.adoranwodo.gottrivia.utils.SharedPreferenceHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = SharedPreferenceHelper(this)

        if(pref.isFirstInstallation()){
           pref.setFirstInstall()
        }

        btn_play.setOnClickListener {
            val intent = Intent(applicationContext, LevelActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }

        linear_layout_score.setOnClickListener {
            val intent = Intent(applicationContext, ScoresActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }

        linear_layout_rules.setOnClickListener {
            val intent = Intent(applicationContext, RulesActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
        }
    }
}
