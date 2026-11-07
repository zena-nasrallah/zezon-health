package com.example.zezon

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout_profile_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fullName = intent.getStringExtra("EXTRA_FULL_NAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")
        val phone = intent.getStringExtra("EXTRA_PHONE")
        val department = intent.getStringExtra("EXTRA_DEPARTMENT")

        if (!fullName.isNullOrBlank()) {
            findViewById<TextView>(R.id.tv_full_name).text = fullName
        }
        if (!email.isNullOrBlank()) {
            findViewById<TextView>(R.id.tv_email).text = email
        }
        if (!phone.isNullOrBlank()) {
            findViewById<TextView>(R.id.tv_phone).text = phone
        }
        if (!department.isNullOrBlank()) {
            findViewById<TextView>(R.id.tv_department).text = "Department: $department"
        }

        findViewById<Button>(R.id.btn_edit_profile).setOnClickListener {
            finish()
        }
    }
}
