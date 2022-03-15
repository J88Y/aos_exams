package com.example.uncaught_exception_handle.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uncaught_exception_handle.databinding.ActivityErrorBinding
import kotlin.system.exitProcess

class ErrorActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.btnReload.setOnClickListener {
            exitProcess(-1)
        }
    }
    
}