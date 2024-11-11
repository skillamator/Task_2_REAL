package com.task3.task2real.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.task3.task2real.Art
import java.util.UUID
import java.util.concurrent.Flow

@Dao
interface ArtDao {
    @Query("SELECT * FROM art")
    suspend fun getArts(): List<Art>

    @Query("SELECT * FROM art WHERE id=(:id)")
    suspend fun getArt(id: UUID): Art
}