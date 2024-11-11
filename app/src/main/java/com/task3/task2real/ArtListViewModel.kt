package com.task3.task2real

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

private const val TAG = "ArtListViewModel"


class ArtListViewModel: ViewModel() {
    private val artRepository = ArtRepository.get()
    val arts = mutableListOf<Art>()

    init {
        Log.d(TAG, "init starting")
        viewModelScope.launch {
            Log.d(TAG, "coroutine launched")
            arts += loadArts()
            Log.d(TAG, "Loading art ended")
        }
    }


    suspend fun loadArts(): List<Art> {
        val fetchedArts = artRepository.getArts()
        Log.d(TAG, "Fetched arts: $fetchedArts") // Add this line
       return artRepository.getArts()
    }
}

