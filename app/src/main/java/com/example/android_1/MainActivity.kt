package com.example.android_1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 버튼 클릭 시 text 값을 변경하기 위해 담아준다.
        val tv: TextView = findViewById(R.id.tv_title)

        // 2. TextView 의 text 값을 동적으로 변경
        tv.text = "변경"

        // 3. Button 에 클릭 리스너 달기
        val button: Button = findViewById(R.id.btn_confirm)
        button.setOnClickListener {
//            it.setBackgroundColor(Color.RED)  // test. 클릭 시 버튼의 배경색을 RED 로 변경
            val et: EditText = findViewById(R.id.et_input)
            tv.text = et.text   // TextView 의 값을 EditText 에 입력된 값으로 변경
            et.setText("")      // EditText 의 값 비워주기
        }

        // 4. Button 에 클릭 리스너 달기
        val toSubButton: Button = findViewById(R.id.btn_toSub)
        toSubButton.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)  // 다음 화면으로 이동하기 위한 Intent 객체 생성

            // 4-1. intent 에 전달한 데이터 담기 (TextView 의 text 값) & my_message 라는 키로 잠궜다.
            intent.putExtra("my_message", tv.text.toString())   // (참고) toString 을 붙이지 않으면 SubActivity 에서 getStringExtra 로 가져오려 할 때 null 로 인식된다.

            startActivity(intent)

            // 4-2. 자기자신 Activity 를 파괴한다.
            finish()
        }
    }
}