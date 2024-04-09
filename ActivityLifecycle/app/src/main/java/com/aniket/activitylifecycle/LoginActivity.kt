package com.durga.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity() : AppCompatActivity() {


    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegisterYourself: TextView
    val validMobileNumber = "0123456"
    val validPassword = arrayOf("avengers", "tony", "steve", "bruce")
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn) {
            val intent = Intent(this@LoginActivity, Avengers_Activity::class.java)
            startActivity(intent)
            finish()
        }

        title = "LOG IN"

        etMobileNumber = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etpassword)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtForgotPassword = findViewById(R.id.txtForgetPwd)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)


        btnLogIn.setOnClickListener {

            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger = "Avenger"
            val intent = Intent(this@LoginActivity, Avengers_Activity::class.java)
            if (mobileNumber == validMobileNumber) {
                when (password) {
                    validPassword[0] -> {

                        nameOfAvenger = "Avenger"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[1] -> {

                        nameOfAvenger = "Iron Man"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[2] -> {

                        nameOfAvenger = "Captain America"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[3] -> {

                        nameOfAvenger = "HULK"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    else -> {
                        Toast.makeText(
                            this@LoginActivity,
                            "Incorrect password",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
            } else {
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()

            }
        }
        txtForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginActivity, ForgotPassword::class.java)
            startActivity(intent)
        }
        txtRegisterYourself.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterYourself::class.java)
            startActivity(intent)
        }

    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String) {
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}