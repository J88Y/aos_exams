package com.example.uncaught_exception_handle

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import com.orhanobut.logger.Logger

class CustomUeHandler(
    private val application: MyApplication,
    private val crashlyticsExceptionHandler: Thread.UncaughtExceptionHandler
) : Thread.UncaughtExceptionHandler {
    
    // static
    companion object {
        // 0이 아닌 경우 비정상 종료를 나타냅니다.
        const val EXIT_STATUS = -10
    }
    
    // 현재 액티비티
    private val activity: Activity? = null
    
    // 초기화
    init {
        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
            }
            
            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
            }
            
            override fun onActivityStarted(activity: Activity) {
                Logger.d("activity Started : $activity")
            }
            
            override fun onActivityResumed(activity: Activity) {
                Logger.d("activity Resumed : $activity")
            }
            
            override fun onActivityPaused(activity: Activity) {
            }
            
            override fun onActivityStopped(activity: Activity) {
            }
            
            override fun onActivityDestroyed(activity: Activity) {
                Logger.d("activity onActivityDestroyed : $activity")
            }
        })
    }
    
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        // 기본 예외처리 핸들러
        // crashlyticsExceptionHandler.uncaughtException(thread, throwable)
        
        Logger.d("thread: $thread / throwable: $throwable")
        
        // 비정상 종료 실행
        // Process.killProcess(Process.myPid())
        // exitProcess(EXIT_STATUS)
    }
    
    /**
     * 에러 화면 보여주기
     */
    private fun startErrorActivity() {
        val intent = Intent()
        // application.startActivity()
    }
    
    
}
