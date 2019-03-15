package com.adoranwodo.gottrivia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.adoranwodo.gottrivia.R
import com.adoranwodo.gottrivia.model.Score

/**
 * Adapter for Score Recylerview
 */
class ScoresAdapter(private val myDataset: ArrayList<Score>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<ScoresAdapter.ScoresViewHolder>() {

    /**
     * View holder for score layout
     * */
    class ScoresViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_score, parent, false)) {
        private var mDifficultyView: TextView? = null
        private var mTimeView: TextView? = null
        private var mScoreView: TextView? = null
        private var mMoodView: ImageView? = null


        init {
            mDifficultyView = itemView.findViewById(R.id.text_view_difficulty)
            mTimeView = itemView.findViewById(R.id.text_view_time)
            mScoreView = itemView.findViewById(R.id.text_view_score)
            mMoodView = itemView.findViewById(R.id.image_view_mood)
        }

        /**
         * Binds score data to the view
         * */
        fun bind(score: Score) {
            val points = score.points
            val difficulty = score.difficulty

            mDifficultyView?.text = difficulty
            mTimeView?.text = score.time
            mScoreView?.text = points.toString()

            if(difficulty == "Easy"){
                when(points){
                    in 70..100 -> mMoodView?.setImageResource(R.drawable.happy)
                    in 50..69 -> mMoodView?.setImageResource(R.drawable.smiling)
                    in 40..59 -> mMoodView?.setImageResource(R.drawable.confused)
                    else -> mMoodView?.setImageResource(R.drawable.crying)
                }
            }

            if(difficulty == "Medium"){
                when(points){
                    in 140..200 -> mMoodView?.setImageResource(R.drawable.happy)
                    in 100..139 -> mMoodView?.setImageResource(R.drawable.smiling)
                    in 80..99 -> mMoodView?.setImageResource(R.drawable.confused)
                    else -> mMoodView?.setImageResource(R.drawable.crying)
                }
            }

            if(difficulty == "Hard"){
                when(points){
                    in 210..300 -> mMoodView?.setImageResource(R.drawable.happy)
                    in 150..209 -> mMoodView?.setImageResource(R.drawable.smiling)
                    in 120..149 -> mMoodView?.setImageResource(R.drawable.confused)
                    else -> mMoodView?.setImageResource(R.drawable.crying)
                }
            }
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