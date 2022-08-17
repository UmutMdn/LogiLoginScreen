package com.umutmadanoglu.logitransornek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.umutmadanoglu.logitransornek.databinding.ActivityMainAnaMenuBinding

class MainAnaMenu : AppCompatActivity() {
    private lateinit var binding: ActivityMainAnaMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainAnaMenuBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.back.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }

        binding.profile.setOnClickListener {
            intent= Intent(applicationContext,MainProfileForm::class.java)
            startActivity(intent)

        }
    }
}