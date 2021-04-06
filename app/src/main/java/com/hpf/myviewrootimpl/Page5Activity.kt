package com.hpf.myviewrootimpl

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import android.os.SystemClock
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread
import kotlinx.android.synthetic.main.activity_text.*
import kotlinx.android.synthetic.main.activity_text.view.*

class Page5Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text3)
        text.text = "onCreate thread = " + Thread.currentThread().name

        thread {
            Looper.prepare()
            text.setOnClickListener {
                Toast.makeText(this, "666", Toast.LENGTH_LONG).show()
            }
            Looper.loop()
        }
    }

}