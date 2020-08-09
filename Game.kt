package com.example.challenggame

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        // Initializing the main component
        val btnRandom = findViewById<Button>(R.id.btnRandom)

        // Names array
        val names: ArrayList<String> = ArrayList()

        // Getting the names from the previous menu
        val i = intent
        try {
            // Inputs names into an array
            val transUserNames = i.getStringArrayListExtra("userNames")

            // Adding names to the array
            var count = 0
            for (pname in transUserNames!!) {
                names.add(pname)
                count += 1
            }

        } catch (e: Exception) {
            // Catch when no names have been received
            names.add("No Names Added")
        }


        // Filling the player slots
        val textViews = arrayOf(R.id.tvName1, R.id.tvName2, R.id.tvName3, R.id.tvName4,
            R.id.tvName5, R.id.tvName6, R.id.tvName7, R.id.tvName8, R.id.tvName9, R.id.tvName10)
        var count1 = 0
        for (name in names) {
            val tv = findViewById<TextView>(textViews[count1])

            tv.text = name
            tv.setTextColor(Color.BLUE)

            count1 += 1
        }

        // Emptying the remainder of player slots to make cleaner
        val restNames = textViews.size - names.size
        if (restNames > 0) {
            for (rest in names.size until textViews.size) {
                val tv = findViewById<TextView>(textViews[rest])

                tv.text = " "

            }
        }

        // Challenge picker
        val challenges = arrayOf("100 Layer Challenge", "7-second Challenge", "Accent Challenge",
                "Aim Crossbar Challenge", "Baby Food Challenge", "Banana and Sprite Challenge",
                "Beans and Chopsticks Challenge", "Big Meal Challenge", "Blind Kissing Challenge",
                "Blindfold Makeup Challenge", "Blindfolded Drawing Challenge",
                "Blindfolded Food Tasting Challenge", "Blindfolded Keepie Uppie Challenge",
                "Brain Freeze Challenge", "Bread Challenge", "Capri Sun Challenge", "Cereal Challenge",
                "Cheez-Its Challenge", "Chubby Bunny Challenge", "Clingfilm Challenge",
                "Cold Tub Challenge", "Cold Water Challenge", "Condom Challenge", "Cook-a-meal Challenge",
                "Cotton Ball Challenge", "Dizzy Challenge", "Don’t Rush Challenge", "Drinking Challenge",
                "Duplicate Image Challenge", "Eat It or Wear It Challenge",
                "31. Exploding Watermelon Challenge", "Extreme Saltine Challenge", "Fast Food Challenge",
                "Flip The Switch Challenge", "Fridge Challenge", "Gallon Milk Challenge",
                "Ghost Pepper Challenge", "Ginger Challenge", "Guess That Pizza Challenge",
                "Guess the Body Part Challenge", "Habanero Challenge", "Hamburger Challenge",
                "High Five and Selfie Challenge", "Hot Cheetos and Takis Challenge", "Hot Pepper Challenge",
                "Hoverboard Challenge", "Huh Challenge", "Human Dartboard Challenge", "Human Shazam Challenge",
                "I’m Just A Kid Challenge", "Ice Bucket Challenge", "Impression Challenge", "Innuendo Bingo",
                "Intentions Challenge", "Internet Slang Challenge", "Jell-O Challenge", "JLo Challenge",
                "Keepie Uppie Challenge", "Ketchup Challenge", "Korean Spicy Noodle Challenge",
                "Language Challenge", "Lemon Challenge", "Mannequin Challenge", "Marmite Challenge",
                "Memorize Challenge", "Music Cover Challenge", "Mustache Photo Challenge",
                "No Lights Makeup", "No Thumbs Challenge", "Not My Hands Challenge",
                "Not My Legs Challenge", "Nutmeg Challenge", "Oreo Challenge", "Pajama Challenge",
                "Penny Can Challenge", "Pickle Challenge", "Pillow Challenge", "Pizza Challenge",
                "Pop Rocks Challenge", "Pound of Steak Challenge", "Powdered Donut Challenge",
                "Push Up Challenge", "Rainbow Milk Challenge", "Raw Garlic Challenge",
                "Raw Onion Challenge", "Rice Purity Test", "Say Anything Challenge", "Say So Challenge",
                "Smoothie Challenge", "Soy Sauce Challenge", "Speed Drawing Challenge", "Stranger Challenge",
                "Sugar Rush Challenge", "Supalonely Challenge", "Tag Questions Challenge", "Target Challenge",
                "The Bottle Cap Challenge", "The Cupid Shuffle Plank Challenge", "The First Move Last Move Challenge",
                "The One Hand Two Hands Challenge", "The Plank Challenge", "The Renegade Challenge",
                "The Savage Challenge", "The Ten Years Challenge", "Tickle Me Challenge", "Tin Can Challenge",
                "Toilet Paper Challenge", "Toothpaste Challenge", "Touch My Body Challenge",
                "Try Not To Laugh Challenge", "Vanilla Extract Challenge", "Warhead Challenge",
                "Wet Head Challenge", "What’s In My Mouth/Hands challenge?", "Whipped cream challenge",
                "Whisper Challenge", "Yoga Challenge")

        // Player picker
        btnRandom.setOnClickListener {
            val rand1 = (names.indices).random()
            val builder1 = AlertDialog.Builder(this@Game)
            builder1.setTitle("Randomly Picked Player")
            builder1.setMessage((names[rand1]))

            val tv = findViewById<TextView>(textViews[rand1])
            tv.setTextColor(Color.MAGENTA)

            // Challenge picker
            builder1.setPositiveButton("Confirm") { dialog, which ->
                Thread.sleep(1000)
                val rand2 = (challenges.indices).random()
                val builder2 = AlertDialog.Builder(this@Game)
                builder2.setTitle("Randomly Picked Challenge")
                builder2.setMessage(challenges[rand2])

                builder2.setPositiveButton("Close") { dialog, which ->
                    tv.setTextColor(Color.BLUE)
                }

                val dialog2: AlertDialog = builder2.create()
                dialog2.show()
            }

            val dialog1: AlertDialog = builder1.create()
            dialog1.show()

        }

    }

}