package com.example.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var currentNum = 0

        // add button logic
        findViewById<Button>(R.id.addBtn).setOnClickListener{
            if (currentNum >= 0) {
                currentNum++
                findViewById<TextView>(R.id.counterView).text = currentNum.toString()
            } else {
                Toast.makeText(this, "Value cannot be less than zero", Toast.LENGTH_SHORT).show()
            }
        }

        // minus button logic
        findViewById<Button>(R.id.minusBtn).setOnClickListener{
            if (currentNum == 0) {
                Toast.makeText(this, "Value cannot be negative", Toast.LENGTH_SHORT).show()
            } else {
                currentNum--
                findViewById<TextView>(R.id.counterView).text = currentNum.toString()
            }
        }

        // reset button
        findViewById<Button>(R.id.resetBtn).setOnClickListener{
            currentNum = 0
            findViewById<TextView>(R.id.counterView).text = currentNum.toString()
        }

        // quit button
        findViewById<Button>(R.id.quitBtn).setOnClickListener{ finishAffinity() }
    }
}