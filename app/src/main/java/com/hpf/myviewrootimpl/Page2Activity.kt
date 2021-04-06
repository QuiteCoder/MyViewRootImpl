package com.hpf.myviewrootimpl

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread
import kotlinx.android.synthetic.main.activity_text.*
import kotlinx.android.synthetic.main.activity_text.view.*

class Page2Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text2)
        text.text = "onCreate thread = " + Thread.currentThread()
        text.setOnClickListener {
            //view配置了固定大小，子线程刷新UI不会报错
            thread {
                text.text = "onClick thread = " + Thread.currentThread()
            }
        }
    }

}