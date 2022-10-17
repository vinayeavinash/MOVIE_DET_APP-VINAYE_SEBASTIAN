package com.vinaye.telusvideoapp.ui.movie

import android.content.Context

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vinaye.telusvideoapp.data.Movie
import com.vinaye.telusvideoapp.utils.CommonMethods
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val mutableMovies = MutableLiveData<Movie>()
    val movies: LiveData<Movie> get() = mutableMovies
    // function for fetch movie details
    fun fetchCards(context: Context) {
        viewModelScope.launch {
            val jsonString = CommonMethods.getJson(context, "movies.json")
            val gson = Gson()
            val listMovie = object : TypeToken<Movie>() {}.type
            val movies = gson.fromJson<Movie>(jsonString, listMovie)
            mutableMovies.value = movies

        }
    }

}