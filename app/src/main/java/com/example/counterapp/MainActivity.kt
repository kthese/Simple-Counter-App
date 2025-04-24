package com.example.counterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog


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
        findViewById<Button>(R.id.quitBtn).setOnClickListener{
            val dialogView = layoutInflater.inflate(R.layout.alert_dialog, null)
            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .create()

            val yesBtn = dialogView.findViewById<Button>(R.id.btnYes)
            val noBtn = dialogView.findViewById<Button>(R.id.btnNo)

            yesBtn.setOnClickListener {
                dialog.dismiss()
                finishAffinity()
            }

            noBtn.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}