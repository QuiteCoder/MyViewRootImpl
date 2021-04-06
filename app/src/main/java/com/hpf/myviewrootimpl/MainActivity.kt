package com.hpf.myviewrootimpl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn01(view: View) {
        val intent: Intent = Intent(this, Page1Activity::class.java)
        startActivity(intent)
    }
    fun btn02(view: View) {
        val intent: Intent = Intent(this, Page2Activity::class.java)
        startActivity(intent)
    }
    fun btn03(view: View) {
        val intent: Intent = Intent(this, Page3Activity::class.java)
        startActivity(intent)
    }
    fun btn04(view: View) {
        val intent: Intent = Intent(this, Page4Activity::class.java)
        startActivity(intent)
    }

    fun btn05(view: View) {
        val intent: Intent = Intent(this, Page5Activity::class.java)
        startActivity(intent)
    }
}