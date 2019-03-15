package com.adoranwodo.gottrivia

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adoranwodo.gottrivia.adapter.ScoresAdapter
import com.adoranwodo.gottrivia.database.ScoreRepository
import kotlinx.android.synthetic.main.activity_scores.*

/**
 * View to show a list of scores
 * */
class ScoresActivity : AppCompatActivity() {

    private lateinit var recyclerView: androidx.recyclerview.widget.RecyclerView
    private lateinit var viewAdapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>
    private lateinit var viewManager: androidx.recyclerview.widget.RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        val scores = ScoreRepository(this).fetch()

        viewManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        viewAdapter = ScoresAdapter(scores)

        recyclerView = my_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

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
