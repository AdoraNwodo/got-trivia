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
        Score("2018-04-04", "200s", "Hard", 16),
        Score("2018-14-04", "300s", "Medium", 26),
        Score("2019-04-04", "120s", "Easy", 79),
        Score("2019-04-08", "90s", "Easy", 82),
        Score("2018-11-04", "100s", "Medium", 26),
        Score("2018-10-04", "140s", "Hard", 34),
        Score("2018-07-04", "40s", "Easy", 53),
        Score("2018-03-04", "20s", "Easy", 6),
        Score("2018-04-12", "230s", "Hard", 26),
        Score("2007-04-04", "190s", "Medium", 64)

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
