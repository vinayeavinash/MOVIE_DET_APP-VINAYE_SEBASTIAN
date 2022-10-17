package com.vinaye.telusvideoapp.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinaye.telusvideoapp.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {
    private val movieAdapter by lazy { MovieAdapter() }
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        //    setup recyclerview  for  generate movie list
        setUpRecyclerview()
        //   get data from  movies.json
        getData()
        return binding.root
    }

    private fun updateUI(moviesArray: ArrayList<com.vinaye.telusvideoapp.data.Metadata>) {
        movieAdapter.setData(moviesArray)
    }

    private fun getData() {
        val movieViewModel =
            ViewModelProvider(this)[MovieViewModel::class.java]
        context?.let { movieViewModel.fetchCards(it) }
        movieViewModel.movies.observe(viewLifecycleOwner) {
            if (it.resultCode == "OK") {
                val moviesArray: ArrayList<com.vinaye.telusvideoapp.data.Metadata> =
                    ArrayList()
                for (movies in it.resultObj.containers) {
                    moviesArray.add(movies.metadata)
                    // update  movies list in to  recyclerview
                    updateUI(moviesArray)
                }

            } else {
                // handle error
                binding.tvDataErrorMessage.visibility = View.VISIBLE
            }
        }
    }

    private fun setUpRecyclerview() {
        _binding!!.rcvMovies.adapter = movieAdapter
        _binding!!.rcvMovies.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}


