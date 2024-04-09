package com.durga.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Avengers_Activity : AppCompatActivity() {
    var titlename: String? = "Avengers"
    lateinit var etMessage: EditText
    lateinit var btnSend: Button
    lateinit var btnLogout: Button
    lateinit var sharedprefernces: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedprefernces = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        setContentView(R.layout.activity_avengers)

        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
        btnLogout = findViewById(R.id.btnLogout)
        titlename = sharedprefernces.getString("Title","The Avengers")

        title = titlename

        btnSend.setOnClickListener {
            var msg: String? = etMessage.text.toString()


            if (msg?.isNotEmpty() == true) {

                val intent = Intent(this@Avengers_Activity, MessageActivity::class.java)

                intent.putExtra("Message", msg)
                startActivity(intent)
            } else {
                Toast.makeText(this@Avengers_Activity, "Say the Sheild operation!!", Toast.LENGTH_SHORT).show()
            }
        }
        btnLogout.setOnClickListener {
            startActivity(Intent(this@Avengers_Activity, LoginActivity::class.java))
            sharedprefernces.edit().clear().apply()
            finish()
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
}
