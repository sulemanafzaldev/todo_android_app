package com.example.todoapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todoapp.DataObject
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pos = intent.getIntExtra("id", -1)

        if (pos != -1) {
            val title = DataObject.getData(pos).title
            val priority = DataObject.getData(pos).periorty

            binding.tvUpdateTitle.setText(title)
            binding.tvUpdatePeriorty.setText(priority)

            binding.btnDelete.setOnClickListener {
                DataObject.deleteItem(pos)
                myIntent()
            }
            binding.btnUpdate.setOnClickListener {
                DataObject.updateItem(
                    pos,
                    binding.tvUpdateTitle.text.toString(),
                    binding.tvUpdatePeriorty.text.toString()
                )
                myIntent()
            }
        }

    }

    private fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}