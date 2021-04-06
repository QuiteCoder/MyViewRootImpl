package com.hpf.myviewrootimpl

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import android.os.SystemClock
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread
import kotlinx.android.synthetic.main.activity_text.*
import kotlinx.android.synthetic.main.activity_text.view.*

class Page4Activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text3)
        text.text = "onCreate thread = " + Thread.currentThread().name
        /*text.setOnClickListener {
            //view配置了wrap_content，子线程刷新UI会报错
            //但是主线程更新完UI，立马给子线程更新是不会报错的
            text.text = "onCreate thread = " + Thread.currentThread()
            thread {
                text.text = "onClick thread = " + Thread.currentThread()
            }
        }*/

        thread {
            Looper.prepare()
            var button = Button(this)
            button.text = "init"
            val layoutParams = WindowManager.LayoutParams()
            windowManager.addView(button,WindowManager.LayoutParams())
            button.setOnClickListener {
                button.text = "${Thread.currentThread().name}:${SystemClock.uptimeMillis()}"
            }
            Looper.loop()
        }
    }

}