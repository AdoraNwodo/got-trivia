package com.adoranwodo.gottrivia.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.adoranwodo.gottrivia.R
import com.adoranwodo.gottrivia.data.Score

class ScoresAdapter(private val myDataset: Array<Score>) :
    RecyclerView.Adapter<ScoresAdapter.ScoresViewHolder>() {

    class ScoresViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_score, parent, false)) {
        private var mDifficultyView: TextView? = null
        private var mTimeView: TextView? = null
        private var mScoreView: TextView? = null


        init {
            mDifficultyView = itemView.findViewById(R.id.text_view_difficulty)
            mTimeView = itemView.findViewById(R.id.text_view_time)
            mScoreView = itemView.findViewById(R.id.text_view_score)
        }

        fun bind(score: Score) {
            mDifficultyView?.text = score.difficulty
            mTimeView?.text = score.time
            mScoreView?.text = score.points.toString()
        }

    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ScoresAdapter.ScoresViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ScoresViewHolder(inflater, parent)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ScoresViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val score: Score = myDataset[position]
        holder.bind(score)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}