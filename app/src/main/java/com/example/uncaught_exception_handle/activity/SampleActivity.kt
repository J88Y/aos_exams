package com.example.uncaught_exception_handle.activity

import android.content.Intent
import android.os.Bundle
import android.os.Process
import androidx.appcompat.app.AppCompatActivity
import com.example.uncaught_exception_handle.activity.common.BaseActivity
import com.example.uncaught_exception_handle.databinding.ActivitySampleBinding
import kotlin.system.exitProcess

class SampleActivity : BaseActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // 클릭) 에러 발생
        binding.btnErr.setOnClickListener {
            throw NumberFormatException("테스트 NFE")
        }
        
        binding.btnStartActivity.setOnClickListener {
            startActivity(Intent(this, SampleActivityB::class.java))
        }
        
        // 클릭) exitSys
        binding.btnExitSys.setOnClickListener {
            // 앱을 재시작하고 activityStack 에서 한 단계 전인 상태로 뜨게 됩니다.
            // ex) ActivityA에서 ActivityB 를 시작했고, Activity B 에서 System.exit(0) 를 호출하면 앱이 종료됐다가
            // ActvityA 가 즉시 시작됩니다.
            System.runFinalization()
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