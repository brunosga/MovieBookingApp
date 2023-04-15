package com.example.movieapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.squareup.picasso.Picasso

@Suppress("DEPRECATION")
class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val movie: Movie? = intent.getSerializableExtra("movie") as? Movie

        if (movie != null) {
            setupMovieData(movie)
        } else {
            Log.e("MovieActivity", "Movie object is null")
        }
    }

    @SuppressLint("SetTextI18n", "WrongViewCast", "ResourceType")
    private fun setupMovieData(movie: Movie) {


        val movieImage: ImageView = findViewById(R.id.ivImage)
        val movieTitle: TextView = findViewById(R.id.tvTitle)
        val movieCertification: TextView = findViewById(R.id.tvCertification)
        val movieActors: TextView = findViewById(R.id.tvStarring)
        val movieDescription: TextView = findViewById(R.id.tvDescription)
        val movieRunningTime: TextView = findViewById(R.id.tvRunningTime)
        val seatsSelected: TextView = findViewById(R.id.tvSeatsSelected)
        val plusButton: MaterialButton = findViewById(R.id.btnPlus)
        val minusButton: MaterialButton = findViewById(R.id.btnMinus)
        val movieSeatsRemaining: TextView = findViewById(R.id.tvSeatsRemaining)

        Picasso.get()
            .load(movie.image)
            .into(movieImage)

        movieTitle.text = movie.title
        movieCertification.text = movie.contentRating
        movieActors.text = movie.stars
        movieDescription.text = movie.plot
        movieRunningTime.text = movie.runtimeStr
        seatsSelected.text = movie.seatsSelected.toString()

        if (movie.seatsRemaining == 0) {
            movieSeatsRemaining.text = getString(R.string.sold_out)
        } else {
            movieSeatsRemaining.text = getString(R.string.tvSeatsRemaining, movie.seatsRemaining)
        }

        fun updateBtnStates() {
            plusButton.isEnabled = movie.seatsRemaining > 0
            minusButton.isEnabled = movie.seatsSelected > 0
        }
         updateBtnStates()

        plusButton.setOnClickListener {
            if (movie.seatsRemaining > 0) {
                movie.seatsSelected++
                movie.seatsRemaining--
                seatsSelected.text = movie.seatsSelected.toString()
                movieSeatsRemaining.text = getString(R.string.tvSeatsRemaining, movie.seatsRemaining)
                updateBtnStates()
            }
        }
//
        minusButton.setOnClickListener {
            if (movie.seatsSelected > 0) {
                movie.seatsSelected--
                movie.seatsRemaining++
                seatsSelected.text = movie.seatsSelected.toString()
                movieSeatsRemaining.text = getString(R.string.tvSeatsRemaining, movie.seatsRemaining)
                updateBtnStates()
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val movie: Movie? = intent.getSerializableExtra("movie") as? Movie
        if (movie != null) {
            val resultIntent = Intent()
            resultIntent.putExtra("updatedMovie", movie)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        super.onBackPressed()
    }
}
