package com.example.modev4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sehir_aciklama.*

class sehir_aciklama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sehir_aciklama)

        var bundle = intent.extras
        imageView2.setImageResource(bundle!!.getInt("image"))
        textView2.text = bundle!!.getString("name")
        des.text = bundle.getString("des")

    }
}