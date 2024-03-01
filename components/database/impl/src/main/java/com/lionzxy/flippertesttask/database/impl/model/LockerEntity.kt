package com.lionzxy.flippertesttask.database.impl.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("lockers_table")
data class LockerEntity(
    @PrimaryKey
    val number: Int,
    @ColumnInfo("key_number")
    val keyNumber: Int? = null
)
