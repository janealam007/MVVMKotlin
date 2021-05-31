package com.robustbinary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.robustbinary.model.Movie
import com.robustbinary.mvvmkotlin.databinding.AdapterMovieBinding

class MovieAdapter: Adapter<MovieView>() {
    var movies = mutableListOf<Movie>()

    fun setMovieList(movie: List<Movie>){
        this.movies = movie.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieView {
        var inflater = LayoutInflater.from(parent.context)
        var binding = AdapterMovieBinding.inflate(inflater,parent,false)
        return MovieView(binding)
    }

    override fun onBindViewHolder(holder: MovieView, position: Int) {
        var movie = movies[position]
        holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return  movies.size
    }
}

class MovieView(var binding: AdapterMovieBinding): ViewHolder(binding.root)