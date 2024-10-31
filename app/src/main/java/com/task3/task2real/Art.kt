package com.task3.task2real

import java.util.Date
import java.util.UUID

data class Art(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)


