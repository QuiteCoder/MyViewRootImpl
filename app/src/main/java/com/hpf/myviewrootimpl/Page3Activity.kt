package com.hpf.myviewrootimpl

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread
import kotlinx.android.synthetic.main.activity_text.*
import kotlinx.android.synthetic.main.activity_text.view.*

class Page3Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        text.text = "onCreate thread = " + Thread.currentThread()
        text.setOnClickListener {
            //view配置了wrap_content，子线程刷新UI会报错
            //但是主线程更新完UI，立马给子线程更新是不会报错的
            text.text = "onCreate thread = " + Thread.currentThread()
            thread {
                text.text = "onClick thread = " + Thread.currentThread()
            }
        }
    }

}