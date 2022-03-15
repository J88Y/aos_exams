package com.example.uncaught_exception_handle

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

class MyApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        //
        Logger.addLogAdapter(AndroidLogAdapter())
        setCrashHandler()
    }
    
    /**
     * UeCrashHandler
     */
    private fun setCrashHandler() {
        // 기본 핸들러
        val defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler() ?: return
        // 기본 핸들러
        Thread.setDefaultUncaughtExceptionHandler(
            CustomUeHandler(this, defaultExceptionHandler)
        )
    }
    
    
}