package com.example.moviebooktracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebooktracker.R


class MovieBookAdapter(private val movieBookList: List<MovieBook>) :
    RecyclerView.Adapter<MovieBookAdapter.MovieBookViewHolder>() {


    inner class MovieBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.itemTitle)
        val rating: TextView = itemView.findViewById(R.id.itemRating)
        val type: TextView = itemView.findViewById(R.id.itemType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieBookViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_book, parent, false)
        return MovieBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieBookViewHolder, position: Int) {

        val movieBook = movieBookList[position]
        holder.title.text = movieBook.title
        holder.rating.text = "Ocena: ${movieBook.rating}"
        holder.type.text = if (movieBook.isBook) "Książka" else "Film"
    }

    override fun getItemCount(): Int = movieBookList.size
}
