package com.example.tugaspapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaspapb.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        binding.apply {
            if (name!=null) {
                tvHello.setText("Hello " + name)
            }
            btnHome.setOnClickListener{
                val intent = Intent(this@HomeActivity, HomeActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
            btnCard.setOnClickListener {
                val intent = Intent(this@HomeActivity, CardActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
            btnProfile.setOnClickListener {
                val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
    }
}