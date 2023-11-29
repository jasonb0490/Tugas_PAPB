package com.example.tugaspapb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspapb.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        firebaseAuth = Firebase.auth



        binding.apply {
            btnLogin.setOnClickListener {
                val name = etEmail.text.toString()
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val nama = intent.getStringExtra("name")
                val email1 = intent.getStringExtra("email")

                if (password.isNotEmpty() && email.isNotBlank()){
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            intent.putExtra("name", nama)
                            intent.putExtra("email", email1)
                            startActivity(intent)

                            Toast.makeText(
                                this@LoginActivity,
                                "LOGIN BERHASIL",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else{
                            Toast.makeText(
                                this@LoginActivity,
                                "LOGIN GAGAL",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }else{
                    Toast.makeText(
                        this@LoginActivity,
                        "Jangan Kosongkan Form",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            tvRegister.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignupActivity::class.java)
                startActivity(intent)
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            val nama = intent.getStringExtra("name")
            val email1 = intent.getStringExtra("email")
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("name", nama)
            intent.putExtra("email", email1)
            startActivity(intent)
            finish()
        }
    }
}