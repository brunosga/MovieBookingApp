package com.example.movieapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import okhttp3.*
import java.io.IOException
import kotlin.random.Random

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://gist.githubusercontent.com/brunosga/7560fb5125364f70c2d20a50fff1584f/raw/0090b216bdd9ed8a1ce7469dc3de934397496e6e/movie.json"
        makeHTTPRequest(url)


        movieAdapter = MovieAdapter(emptyList()) { movie ->
            val intent = Intent(this, MovieActivity::class.java)
            intent.putExtra("movie", movie)
            startActivityForResult(intent, MOVIE_ACTIVITY_REQUEST_CODE)}

       val recyclerView: RecyclerView = findViewById(R.id.rvMovie)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = movieAdapter

        val adImage = findViewById<ImageView>(R.id.adImage)
        val randomSeed = Random.nextInt(1000)
        val url2 = "https://picsum.photos/seed/$randomSeed/800/50?grayscale&blur=10"
        Picasso.get().load(url2).into(adImage)

    }


    private fun makeHTTPRequest(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("MainAct", "GET request failed $e")
            }

            override fun onResponse(call: Call, response: okhttp3.Response) {
                if (response.isSuccessful) {
                    val resBody = response.body?.string()
                    val gson = Gson()
                    val movies: Array<Movie> = gson.fromJson(resBody, Array<Movie>::class.java)
                    Log.i("MainAct", "Response: $resBody")
                    movies.forEach {
                        Log.i("MainAct", "Movies $it")
                    }
                    movies.forEach { movie ->
                        movie.seatsRemaining = Random.nextInt(0, 16)
                    }
                    runOnUiThread {
                        movieAdapter.updateMovies(movies.toList())
                    }
                }
            }
        })
    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == MOVIE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val updatedMovie = data?.getSerializableExtra("updatedMovie") as? Movie
            updatedMovie?.let {
                movieAdapter.updateMovie(it)
            }
        }
    }
    companion object {
        const val MOVIE_ACTIVITY_REQUEST_CODE = 1001
    }
}


