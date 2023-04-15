package com.example.movieapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private var movies: List<Movie>, private val onClickItem: (Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovie(updatedMovie: Movie) {
        val index = movies.indexOfFirst { it.id == updatedMovie.id }
        if (index != -1) {
            val newMovies = movies.toMutableList()
            newMovies[index] = updatedMovie
            movies = newMovies
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_movie_info, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onClickItem(movie)
        }
    }


}