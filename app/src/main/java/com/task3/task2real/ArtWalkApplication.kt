package com.task3.task2real

import android.app.Application
import android.os.StrictMode

class ArtWalkApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ArtRepository.initialize(this)
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
        ArtRepository.initialize(this)
    }



}