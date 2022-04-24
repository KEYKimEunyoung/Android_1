package com.example.android_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // intent 가 my_message 라는 Extra 를 갖고 있다면, 그 값을 가져와서 TextView 에 담아줘라.
        if (intent.hasExtra("my_message")) {
//            Log.d("mymymy", intent.getStringExtra("my_message").toString())   // 로그 찍어보기(d 는 Debug 를 의미)
            findViewById<TextView>(R.id.tv_received).text = intent.getStringExtra("my_message")
        }
    }
}