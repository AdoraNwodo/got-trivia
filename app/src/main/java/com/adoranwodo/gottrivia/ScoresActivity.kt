package com.adoranwodo.gottrivia

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.adoranwodo.gottrivia.adapter.ScoresAdapter
import com.adoranwodo.gottrivia.model.Score
import kotlinx.android.synthetic.main.activity_scores.*

class ScoresActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val scores = arrayOf(
        Score( time = "200s", difficulty = "Hard", points = 16),
        Score(time = "300s", difficulty = "Medium", points = 26)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        viewManager = LinearLayoutManager(this)
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
}
