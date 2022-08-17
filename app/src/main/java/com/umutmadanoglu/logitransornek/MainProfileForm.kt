package com.umutmadanoglu.logitransornek

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.umutmadanoglu.logitransornek.databinding.ActivityMainProfileFormBinding

class MainProfileForm : AppCompatActivity() {
    lateinit var binding: ActivityMainProfileFormBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainProfileFormBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        sharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)
        var kayitliIsim=sharedPreferences.getString("isim","")
        var kayitliSoyIsim=sharedPreferences.getString("soyIsim","")
        var kayitliEmail=sharedPreferences.getString("mail","")
        var kayitliDepartman=sharedPreferences.getString("departman","")
        var kayitliTelefon=sharedPreferences.getString("phone","")


        binding.isim2.text="İsim:$kayitliIsim"
        binding.soySim2.text="Soyisim:$kayitliSoyIsim"
        binding.email2.text="Email:$kayitliEmail"
        binding.departman2.text="Departman:$kayitliDepartman"
        binding.phone2.text="Telefon Numarası:$kayitliTelefon"


        binding.onayButton.setOnClickListener {



            intent= Intent(applicationContext,MainAnaMenu::class.java)
            startActivity(intent)


        }

    }
}