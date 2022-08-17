package com.umutmadanoglu.logitransornek
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.umutmadanoglu.logitransornek.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var preferences: SharedPreferences  //xml deki verilere ulaşmak icin referans oluşturduk
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)


            binding.buttonSistemeGiris.setOnClickListener {

                var girisKullaniciAdi=binding.serverText.text.toString()
                var girisKullaniciSifre=binding.pinText.text.toString()
                var kayitliKulaniciAdi=preferences.getString("kullanici","")
                var kayitliSifre=preferences.getString("paralo","")
                if (girisKullaniciAdi.length!=0 || girisKullaniciSifre.length!=0){
                    if ((kayitliKulaniciAdi==girisKullaniciAdi)&&(kayitliSifre==girisKullaniciSifre)){
                        intent= Intent(applicationContext,MainAnaMenu::class.java)
                        startActivity(intent)

                    }else{
                        Toast.makeText(applicationContext,"Kullanici Adi Veya Sifre Hatali",Toast.LENGTH_LONG).show()
                    }

                }else{
                    Toast.makeText(applicationContext,"Giriş Başarısız",Toast.LENGTH_LONG).show()
                }
            }

        binding.buttonKayitOl.setOnClickListener {
            intent=Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        }
    }
}