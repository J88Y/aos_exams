package com.example.uncaught_exception_handle.activity.common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uncaught_exception_handle.activity.ErrorActivity
import com.orhanobut.logger.Logger
import kotlin.system.exitProcess

open class BaseActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        onUncaughtException()
        // Process.killProcess(Process.myPid())
        // exitProcess(-1)
    }
    
    private fun onUncaughtException(/*onException: () -> Unit*/) {
        // 예상치 못한 에러 발생
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Logger.d("thread: $thread / throwable: $throwable")
            
            val intent = Intent(this, ErrorActivity::class.java)
            startActivity(intent)
            
            // Process.killProcess(Process.myPid())
            exitProcess(-1)
        }
    }
    
}