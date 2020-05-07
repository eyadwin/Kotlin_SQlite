package com.example.kotlin_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQueryAll()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!=null){
            when (item.itemId) {
                R.id.Add -> {
                    var intent = Intent(this, NoteActivity::class.java)
                    startActivity(intent)
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        loadQueryAll()
        super.onResume()
    }

    fun loadQueryAll(){
        var dbManager = NoteDbManager(this)
        var cursor = dbManager.queryAll()

        var listNotes = ArrayList<String>()

        while (cursor.moveToNext()) {
            var title = cursor.getString(cursor.getColumnIndex("Title"))
            listNotes.add(title)
        }

        var notesAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_expandable_list_item_1 ,
            listNotes)
        lvNotes.adapter = notesAdapter

    }
}
