package com.task3.task2real.database

import androidx.room.TypeConverter
import java.nio.ByteBuffer
import java.sql.Blob
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


    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun toUUID(uuid: String): UUID {
        return UUID.fromString(uuid)
    }

//    @TypeConverter
//    fun fromByteArray(byteArray: ByteArray): Blob {
//        return byteArray // Save as BLOB in the database
//    }
//
//    @TypeConverter
//    fun toByteArray(blob: Blob): ByteArray {
//        return blob // Retrieve as ByteArray from the database

        @TypeConverter
        fun fromUUIDToBlob(uuid: UUID): ByteArray {
            val byteBuffer = ByteBuffer.wrap(ByteArray(16))
            byteBuffer.putLong(uuid.mostSignificantBits)
            byteBuffer.putLong(uuid.leastSignificantBits)
            return byteBuffer.array()
        }

        @TypeConverter
        fun toUUIDFromBlob(blob: ByteArray): UUID {
            val byteBuffer = ByteBuffer.wrap(blob)
            val mostSignificantBits = byteBuffer.long
            val leastSignificantBits = byteBuffer.long
            return UUID(mostSignificantBits, leastSignificantBits)
        }
    }
