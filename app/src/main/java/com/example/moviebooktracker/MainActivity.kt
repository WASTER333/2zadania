package com.example.moviebooktracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviebooktracker.R

class MainActivity : AppCompatActivity() {

    private lateinit var editTitle: EditText
    private lateinit var editGenre: EditText
    private lateinit var editDescription: EditText
    private lateinit var ratingBar: SeekBar
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonAdd: Button
    private lateinit var recyclerView: RecyclerView

    private val movieBookList = mutableListOf<MovieBook>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editTitle = findViewById(R.id.editTitle)
        editGenre = findViewById(R.id.editGenre)
        editDescription = findViewById(R.id.editDescription)
        ratingBar = findViewById(R.id.ratingBar)
        radioGroup = findViewById(R.id.radioGroup)
        buttonAdd = findViewById(R.id.buttonAdd)
        recyclerView = findViewById(R.id.recyclerView)


        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MovieBookAdapter(movieBookList)
        recyclerView.adapter = adapter


        buttonAdd.setOnClickListener {
            val title = editTitle.text.toString()
            val genre = editGenre.text.toString()
            val description = editDescription.text.toString()
            val rating = ratingBar.progress
            val isBook = radioGroup.checkedRadioButtonId == R.id.radioBook


            val movieBook = MovieBook(title, genre, description, rating, isBook)
            movieBookList.add(movieBook)


            adapter.notifyDataSetChanged()


            editTitle.text.clear()
            editGenre.text.clear()
            editDescription.text.clear()
        }
    }
}
