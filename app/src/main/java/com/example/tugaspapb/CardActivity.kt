package com.example.tugaspapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaspapb.databinding.ActivityCardBinding

private lateinit var binding: ActivityCardBinding

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        binding.apply {
            if (name!=null) {
                tvUName.setText(name)
            }
            btnHome.setOnClickListener{
                val intent = Intent(this@CardActivity, HomeActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
            btnCard.setOnClickListener {
                val intent = Intent(this@CardActivity, CardActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
            btnProfile.setOnClickListener {
                val intent = Intent(this@CardActivity, ProfileActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
    }
}