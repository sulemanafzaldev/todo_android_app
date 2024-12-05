package com.example.todoapp.ui

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todoapp.DataObject
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityCreateBinding

class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAdd.setOnClickListener {
            if (binding.etCreateTitle.text.toString().trim()
                    .isNotEmpty() && binding.etCreatePeriorty.text.toString().trim().isNotEmpty()
            ) {
                val title = binding.etCreateTitle.text.toString()
                val priority = binding.etCreatePeriorty.text.toString()

                DataObject.setData(title, priority)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }

    }
}