package com.example.uncaught_exception_handle.activity

import android.content.Intent
import android.os.Bundle
import android.os.Process
import com.example.uncaught_exception_handle.activity.common.BaseActivity
import com.example.uncaught_exception_handle.databinding.ActivityMainBinding
import kotlin.system.exitProcess

/**
 * https://www.tabnine.com/code/java/methods/android.os.Process/killProcess
 * https://calvinjmkim.tistory.com/21
 */
class MainActivity : BaseActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 클릭) 에러 발생
        binding.btnErr.setOnClickListener {
            throw NullPointerException("테스트 NPE")
        }
        
        // 클릭) 다음 액티비티 실행
        binding.btnStartActivity.setOnClickListener {
            startActivity(Intent(this, SampleActivity::class.java))
        }
        
        // 클릭) 다음 액티비티 실행
        binding.btnExitSys.setOnClickListener {
            Process.killProcess(Process.myPid());
            exitProcess(10);
        }
        
        // 클릭) 다음 액티비티 실행
        binding.btnKillProcess.setOnClickListener {
            Process.killProcess(Process.myPid())
        }
        
        // 클릭) 다음 액티비티 실행
        binding.btnExitProcess.setOnClickListener {
            Process.killProcess(Process.myPid())
            System.exit(-1)
        }
        
        // 클릭) 다음 액티비티 실행
        binding.btnKillAndExit.setOnClickListener {
            finishAndRemoveTask()
            Process.killProcess(Process.myPid())
            exitProcess(-1)
        }
        
    }
    
}