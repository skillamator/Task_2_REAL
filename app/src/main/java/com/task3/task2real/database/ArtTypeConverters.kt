package com.task3.task2real.database

import androidx.room.TypeConverter
import java.util.Date
import java.util.UUID


class ArtTypeConverters {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(millisSinceEpoch: Long): Date {
        return Date(millisSinceEpoch)
    }
}


//    @TypeConverter
//    fun fromUUID(uuid: UUID): String {
//        return uuid.toString()
//    }
//
//    @TypeConverter
//    fun toUUID(uuid: String): UUID {
//        return UUID.fromString(uuid)
//    }
