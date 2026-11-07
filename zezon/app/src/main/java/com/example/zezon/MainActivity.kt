package com.example.zezon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout_signup_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etFullName = findViewById<EditText>(R.id.et_full_name)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPhone = findViewById<EditText>(R.id.et_phone)
        val spinnerDepartment = findViewById<Spinner>(R.id.spinner_department)
        val btnSignUp = findViewById<Button>(R.id.btn_sign_up)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("EXTRA_FULL_NAME", etFullName.text.toString().trim())
                putExtra("EXTRA_EMAIL", etEmail.text.toString().trim())
                putExtra("EXTRA_PHONE", etPhone.text.toString().trim())
                if (spinnerDepartment.selectedItemPosition > 0) {
                    putExtra("EXTRA_DEPARTMENT", spinnerDepartment.selectedItem.toString())
                }
            }
            startActivity(intent)
        }
    }
}
