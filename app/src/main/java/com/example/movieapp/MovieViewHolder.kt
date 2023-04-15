package com.example.movieapp

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieViewHolder (view: View): RecyclerView.ViewHolder(view) {

    private val movieTitle = itemView.findViewById<TextView>(R.id.tvTitle)
    private val movieImage = itemView.findViewById<ImageView>(R.id.ivImage)
    private val movieRuntime = itemView.findViewById<TextView>(R.id.tvRunningTime)
    private val movieContentRating = itemView.findViewById<TextView>(R.id.tvCertification)
    private val movieStars = itemView.findViewById<TextView>(R.id.tvStarring)
    private val movieSeatsRemaining = itemView.findViewById<TextView>(R.id.tvSeatsRemaining)


    fun bind(movie: Movie) {

        Picasso.get()
            .load(movie.image)
            .into(movieImage)

        movieTitle.text = movie.title
        movieRuntime.text = movie.runtimeStr
        movieContentRating.text = movie.contentRating
        movieStars.text = movie.stars

        when {
            movie.seatsSelected > 0 -> {
                movieSeatsRemaining.text = itemView.context.getString(R.string.seats_selected, movie.seatsSelected)
                movieSeatsRemaining.setTextColor(Color.GREEN)

            }
            movie.seatsRemaining == 0 -> {
                movieSeatsRemaining.text = itemView.context.getString(R.string.sold_out)
                movieSeatsRemaining.setTextColor(Color.parseColor("#C6C6C6"))

            }
            else -> {
                movieSeatsRemaining.text = itemView.context.getString(R.string.tvSeatsRemaining, movie.seatsRemaining)
                movieSeatsRemaining.setTextColor(Color.parseColor("#C6C6C6"))

            }
        }

        val fillingFastBadge = itemView.findViewById<TextView>(R.id.tvBadge)
        if (movie.seatsRemaining in 1..2) {
            fillingFastBadge.visibility = View.VISIBLE
        } else {
            fillingFastBadge.visibility = View.GONE
        }
    }

}