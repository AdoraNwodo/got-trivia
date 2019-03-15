package com.adoranwodo.gottrivia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adoranwodo.gottrivia.utils.SharedPreferenceHelper
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main Activity. View for the game home screen
 * */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = SharedPreferenceHelper(this)

        if(pref.isFirstInstallation()){
           pref.setFirstInstall()
        }

        btn_play.setOnClickListener { launchIntent(LevelActivity::class.java) }
        linear_layout_score.setOnClickListener { launchIntent(ScoresActivity::class.java) }
        linear_layout_rules.setOnClickListener { launchIntent(RulesActivity::class.java) }
    }

    @SuppressLint("PrivateResource")
    private fun launchIntent(activity: Class<*>){
        val intent = Intent(applicationContext, activity)
        startActivity(intent)
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }

    @SuppressLint("PrivateResource")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out)
    }
}
