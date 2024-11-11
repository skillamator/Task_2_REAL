package com.task3.task2real.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task3.task2real.Art


@Database(entities = [Art::class], version = 1)
@TypeConverters(ArtTypeConverters::class)
abstract class ArtDatabase:RoomDatabase() {
    abstract fun artDao(): ArtDao
}