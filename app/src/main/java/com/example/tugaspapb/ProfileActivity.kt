package com.example.tugaspapb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaspapb.databinding.ActivityProfileBinding

private lateinit var binding: ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        binding.apply {
            if (name!=null) {
                tvUName.setText(name)
            }
            if(email!=null) {
                tvUEmail.setText(email)
            }
            btnHome.setOnClickListener{
                val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
            btnCard.setOnClickListener {
                val intent = Intent(this@ProfileActivity, CardActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
            btnProfile.setOnClickListener {
                val intent = Intent(this@ProfileActivity, ProfileActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("email", email)
                startActivity(intent)
            }
        }
    }
}