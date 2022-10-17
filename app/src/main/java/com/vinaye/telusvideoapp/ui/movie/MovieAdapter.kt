package com.vinaye.telusvideoapp.ui.movie
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.vinaye.telusvideoapp.R

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private var myList = mutableListOf<com.vinaye.telusvideoapp.data.Metadata>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // init    widgets
        val movieTitle = holder.itemView.findViewById<TextView>(R.id.tv_title)
        val movieDesc = holder.itemView.findViewById<TextView>(R.id.tv_description)
        val movieImage = holder.itemView.findViewById<ImageView>(R.id.iv_movie_banner)

        // set values   -  widgets
        movieTitle.text = myList[position].title
        movieDesc.text = myList[position].longDescription

        Glide.with(holder.itemView.context)
            .load(myList[position].iconicImage169)
            .centerCrop()
            .error(R.drawable.ic_movies)
            .transition(DrawableTransitionOptions.withCrossFade()).into(movieImage)

    }

    fun setData(newList: List<com.vinaye.telusvideoapp.data.Metadata>) {
        myList = newList.toMutableList()
        notifyDataSetChanged()

    }

}