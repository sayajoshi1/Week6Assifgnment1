package com.saya.week6assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etusername : EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etusername=findViewById(R.id.etusername)
        etpassword=findViewById(R.id.etpassword)
        btnlogin=findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {
            val username = etusername.getText().toString()
            val password = etpassword.getText().toString()
            if (username == "softwarica" && password == "coventry") {
                Toast.makeText(
                    this@MainActivity,
                    "User Succesfully Logged in",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                etusername.setText("");
                etpassword.setText("");
                etusername.requestFocus()
                Toast.makeText(this@MainActivity, "Invalid Username or Password", Toast.LENGTH_LONG).show()
            }
        }



    }
}