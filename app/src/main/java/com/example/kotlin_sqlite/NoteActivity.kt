package com.example.kotlin_sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
    }
    fun btnAddClicked(view: View){

            var dbManager = NoteDbManager(this)
            var values=ContentValues()
            values.put("Title",etTitle.text.toString())
            values.put("Content",etDesc.text.toString())

            var id = dbManager.insert(values)

            if (id >0){
                Toast.makeText(this,"added successfully",Toast.LENGTH_SHORT).show()
                finish()
            }
            else{
                Toast.makeText(this,"not added successfully",Toast.LENGTH_SHORT).show()
            }
    }

    }
