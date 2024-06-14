package com.example.houseonpalm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 延迟启动主活动
        val splashScreenDuration = 2000 // 启动画面显示时间 (毫秒)
        val intent = Intent(this, MainActivity::class.java)
        window.decorView.postDelayed({
            startActivity(intent)
            finish()
        }, splashScreenDuration.toLong())
    }
}
