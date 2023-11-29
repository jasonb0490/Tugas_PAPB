package com.example.tugaspapb

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tugaspapb.databinding.ActivitySignupBinding
import com.firebase.ui.auth.data.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()


        binding.apply {
            btnSignup.setOnClickListener {

                val name = etName.text.toString()
                val phoneNum = etDOB.text.toString()
                val vehicleType = etVehicleType.text.toString()

                database = FirebaseDatabase.getInstance().getReference("Users")


                if (etEmail.text.isNotBlank() && etName.text.isNotBlank() &&etPassword.text.isNotBlank()) {
                    val email = etEmail.text.toString()
                    val password = etPassword.text.toString()
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener{ task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                                intent.putExtra("name", name)
                                intent.putExtra("email", email)
                                startActivity(intent)
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(
                                    baseContext,
                                    "Authentication failed.",
                                    Toast.LENGTH_SHORT,
                                ).show()
                            }
                        }

                    Toast.makeText(this@SignupActivity, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignupActivity, "Gagal, Mohon isi dengan benar", Toast.LENGTH_SHORT).show()
                }
            }

            tvLogin.setOnClickListener {
                val intent = Intent(this@SignupActivity, LoginActivity::class.java)
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