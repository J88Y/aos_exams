package com.example.uncaught_exception_handle.activity

import android.os.Bundle
import android.os.Process
import com.example.uncaught_exception_handle.activity.common.BaseActivity
import com.example.uncaught_exception_handle.databinding.ActivitySampleBBinding
import kotlin.system.exitProcess

class SampleActivityB : BaseActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btnErr.setOnClickListener {
            throw RuntimeException("예기치 못한 Exception 발생")
        }
        
        binding.btnExitSys.setOnClickListener {
            exitProcess(-10)
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