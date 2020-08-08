package com.example.trial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Register_activity : AppCompatActivity() {

    var user_email:EditText? = null
    var user_password:EditText? = null
    var register_btn:Button? = null
    var firebaseAuth:FirebaseAuth? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activity)

        user_email = findViewById(R.id.user_reg_email)
        user_password = findViewById(R.id.user_register_password)
        register_btn = findViewById(R.id.register)
        firebaseAuth = FirebaseAuth.getInstance()

        register_btn?.setOnClickListener {

            RegisterUser()
        }
    }
    private fun RegisterUser() {
        val email :String = user_email?.text.toString().trim()
        val password : String = user_password?.text.toString().trim()

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "This field cant be empty", Toast.LENGTH_SHORT).show()
        }

        else {
            firebaseAuth?.createUserWithEmailAndPassword(email,password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {


                        override fun onComplete(auth: Task<AuthResult>) {


                            if (auth.isSuccessful) {
                                Toast.makeText(
                                    applicationContext,
                                    "Account created successfully",
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(
                                    Intent(
                                        this@Register_activity,
                                        Login_activity::class.java
                                    )
                                )


                            } else {
                                val error: String? = auth.exception?.message
                                Toast.makeText(applicationContext, "Error" + error,Toast.LENGTH_SHORT).show()
                            }

                            }
                        })

                    }}
    }






