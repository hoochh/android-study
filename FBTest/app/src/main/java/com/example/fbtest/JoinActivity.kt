package com.example.fbtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.fbtest.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class JoinActivity : AppCompatActivity() {
    lateinit var binding: ActivityJoinBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth=Firebase.auth

        binding.btnJoin.setOnClickListener{
            val email = binding.editId.text.toString()
            val password = binding.editPwd.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){ task ->
                    if(task.isSuccessful){
                        val user=auth.currentUser
                        updateUI(user)
    //                    val intent= Intent(this,HomeActivity::class.java)
    //                    startActivity(intent)

                        Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        user?.let {
            binding.txtResult.text = "Email: ${user.email}\nUid: ${user.uid}"
        }
    }
}