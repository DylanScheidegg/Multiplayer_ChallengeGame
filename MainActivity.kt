package com.example.challenggame

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the main components
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvPlayerList = findViewById<TextView>(R.id.tvPlayerList)
        val etPlayerNames = findViewById<EditText>(R.id.etPlayerNames)
        val btnFixNames = findViewById<Button>(R.id.btnFixNames)

        // Name array
        val names: ArrayList<String> = ArrayList()
        var intput: String

        // Inputting names into array
        btnFixNames.setOnClickListener {
            intput = etPlayerNames.text.toString()
            val pList = intput.split(", ")

            // Showing the names for players to see
            var group = ""
            for (pname in pList) {
                names.add(pname)

                group += pname + "\n"

            }

            tvPlayerList.text = group

        }


        // Opens the main game with user names
        btnGenerate.setOnClickListener {
            val intent = (Intent(this, Game::class.java))
            val bundle = Bundle()
            intent.putStringArrayListExtra("userNames", names)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        // Changes the list of players when the list is changed
        etPlayerNames.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                tvPlayerList.text = "...."

            }
        })


    }

}