package com.task3.task2real
import android.content.Context
import androidx.room.Room
import com.task3.task2real.database.ArtDatabase
import java.util.UUID

private const val DATABASE_NAME = "art-database"

class ArtRepository private constructor(context: Context){

    private val database: ArtDatabase = Room
        .databaseBuilder(
        context.applicationContext,
        ArtDatabase::class.java,
        DATABASE_NAME
    )
        .createFromAsset(DATABASE_NAME)
        .build()

    suspend fun getArts(): List<Art> = database.artDao().getArts()
    suspend fun getArt(id: UUID): Art = database.artDao().getArt(id)

    companion object{
        private var INSTANCE: ArtRepository? = null

        fun initialize(context: Context){
            if (INSTANCE == null){
                INSTANCE = ArtRepository(context)
            }
        }

        fun get(): ArtRepository{
            return INSTANCE ?:
            throw java.lang.IllegalStateException("ArtRepository must be initialized")
        }
    }
}