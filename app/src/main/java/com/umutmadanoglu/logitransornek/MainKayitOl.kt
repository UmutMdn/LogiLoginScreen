package com.umutmadanoglu.logitransornek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.umutmadanoglu.logitransornek.databinding.ActivityMainKayitOlBinding


class MainKayitOl : AppCompatActivity() {
    private lateinit var binding: ActivityMainKayitOlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainKayitOlBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)





        binding.buttonKayit.setOnClickListener {
            var SharedPreferences = this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor = SharedPreferences.edit()
            //veri ekleme
            var kayitliKullaniciAdi = binding.kayitKullaniciAdi.text.toString()
            var kayitKullaniciSifre = binding.kayitSifre.text.toString()
            var kayitliKullaniciIsim = binding.isim.text.toString()
            var kayitliSoyIsim = binding.soyIsim.text.toString()
            var kayitliMail = binding.email.text.toString()
            var kayitliPhone = binding.phone.text.toString()
            var kayitliDepartman = binding.departman.text.toString()

            //burada ne yapıyor
            editor.putString("kullanici", "$kayitliKullaniciAdi").apply()
            editor.putString("paralo", "$kayitKullaniciSifre").apply()
            editor.putString("isim", "$kayitliKullaniciIsim").apply()
            editor.putString("soyIsim", "$kayitliSoyIsim").apply()
            editor.putString("mail", "$kayitliMail").apply()
            editor.putString("phone", "$kayitliPhone").apply()
            editor.putString("departman", "$kayitliDepartman").apply()


            binding.kayitKullaniciAdi.text.clear()
            binding.kayitSifre.text.clear()
            binding.isim.text.clear()
            binding.soyIsim.text.clear()
            binding.departman.text.clear()
            binding.email.text.clear()
            binding.phone.text.clear()
            var isValid: Boolean = true


            fun kontrol(): Boolean {
                if (kayitliKullaniciAdi.length == 0) {
                    binding.kayitKullaniciAdi.setError("Kullanici Adi Oluşturulmalı")
                    isValid = false
                };if (kayitKullaniciSifre.length == 0) {
                    binding.kayitSifre.setError("Şifre Oluşturulmalı")
                    isValid = false
                } else if (kayitKullaniciSifre.length > 20) {
                    binding.kayitSifre.setError("Şifre Max 20 Karakterden Oluşmalı")
                    isValid = false
                } else if (kayitKullaniciSifre.length < 8) {
                    binding.kayitSifre.setError("Şifre Min 8 Karakterden Oluşmalı")
                    isValid = false
                };if (kayitliKullaniciIsim.length == 0) {
                    binding.isim.setError("İsim Girilmeli")
                    isValid = false
                };if (kayitliSoyIsim.length == 0) {
                    binding.soyIsim.setError("Soy İsim Girilmeli")
                    isValid = false
                };if (kayitliMail.length == 0) {
                    binding.email.setError("Mail Girlmeli")
                    isValid = false
                } else if (kayitliMail.length != 0) {
                    isValid = android.util.Patterns.EMAIL_ADDRESS.matcher(kayitliMail).matches();
                    binding.email.setError("Geçerli Mail Adres Giriniz")
                }
                ;if (kayitliPhone.length < 11 || kayitliPhone.length > 11) {
                    binding.phone.setError("Telefon Numarası 11 Haneli Olmalı")
                    isValid = false
                };if (kayitliDepartman.length == 0) {
                    binding.departman.setError("Departman Girilmeli")
                    isValid = false
                }
                return isValid
            }

            if (!kontrol()) {
                Toast.makeText(applicationContext, "Kayit Basarisiz", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Kayit Basarili", Toast.LENGTH_LONG).show()
                intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)

            }
        }

    }
}