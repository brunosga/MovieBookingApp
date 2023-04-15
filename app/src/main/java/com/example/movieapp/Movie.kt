package com.example.movieapp

data class Movie(
    val id: String,
    val title: String,
    val image: String,
    val runtimeStr: String,
    val plot: String,
    val contentRating: String,
    val stars: String,
    var seatsRemaining: Int,
    var seatsSelected: Int,
) :java.io.Serializable