package com.durga.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MessageActivity : AppCompatActivity() {
    lateinit var txtMessage: TextView
    var message = "Custom Message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        txtMessage = findViewById(R.id.txtMessage)

        if(intent != null) {
            message = intent.getStringExtra("Message").toString()
            txtMessage.text = message
        }

        Toast.makeText(this, intent?.getStringExtra("Message"), Toast.LENGTH_SHORT).show()

    }
}