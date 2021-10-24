package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val notes = arrayListOf<String>()
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            if (!editText.text.isEmpty()) {
                //db
                var note = editText.text.toString()
                var dbhlr = DBHlr(this)
                dbhlr.savedata(note)
                Toast.makeText(this, "Save successfully", Toast.LENGTH_SHORT).show()
                //recycler view
               // notes.add(note)
                val myRv = findViewById<RecyclerView>(R.id.recyclerView)
               // myRv.adapter = RecyclerViewAdapter(notes)
               // myRv.layoutManager = LinearLayoutManager(this)

                editText.text.clear()
            }else{
                Toast.makeText(this, "The text is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}