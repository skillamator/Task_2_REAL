package com.task3.task2real

import android.app.Application

class ArtWalkApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        ArtRepository.initialize(this)
    }
}