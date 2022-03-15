package com.example.uncaught_exception_handle.activity.common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uncaught_exception_handle.activity.ErrorActivity
import kotlin.system.exitProcess

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // RunTimeException 발생시 동작
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            // 에러 액티비티로 이동.
            val intent = Intent(this, ErrorActivity::class.java)
            startActivity(intent)
            
            // 현재 프로세스를 나가야 함.
            // 아래 메서드를 실행하지 않으면 Thread 안에 갇히게 됨.
            exitProcess(0) // == System.exit(status)
        }
    }
}