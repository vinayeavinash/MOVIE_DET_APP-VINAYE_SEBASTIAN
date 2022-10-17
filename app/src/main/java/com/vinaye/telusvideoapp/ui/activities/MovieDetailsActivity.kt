package com.vinaye.telusvideoapp.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.vinaye.telusvideoapp.R
import com.vinaye.telusvideoapp.databinding.ActivityMovieDetailsBinding
import com.vinaye.telusvideoapp.ui.movie.MovieViewModel

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private var position: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // get  data
        getData()
    }

    private fun getData() {
        val bundle = intent.extras
        position = bundle?.getInt("position")!!
        val movieViewModel =
            ViewModelProvider(this)[MovieViewModel::class.java]
        movieViewModel.fetchCards(this)
        movieViewModel.movies.observe(this) {
            val moviesArray: ArrayList<com.vinaye.telusvideoapp.data.Metadata> = ArrayList()
            if (it.resultCode == "OK") {
                for (i in it.resultObj.containers) {
                    moviesArray.add(i.metadata)
                }
                // set  up  movie info
                setUI(moviesArray)
            } else {
                // error handling
                binding.tvDataErrorMessage.visibility = View.VISIBLE
            }
        }
    }

    private fun setUI(moviesArray: ArrayList<com.vinaye.telusvideoapp.data.Metadata>) {
        binding.tvTitle.text = moviesArray[position].title
        binding.tvLanguage.text = moviesArray[position].language
        binding.tvRatings.text = moviesArray[position].rating
        binding.tvYear.text = moviesArray[position].year
        binding.tvDuration.text = moviesArray[position].duration.toString()
        binding.tvInfoDetails.text = moviesArray[position].longDescription
        Glide.with(this)
            .load(moviesArray[position].image169)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_movies).into(binding.ivBannerDetails)

        Glide.with(this)
            .load(moviesArray[position].image23)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_movies)
            .into(binding.ivDetailsSmallPoster)
    }
}