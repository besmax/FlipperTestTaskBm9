package com.lionzxy.flippertesttask.database.impl.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("keys_table")
data class KeyEntity(
    @PrimaryKey
    val number: Int
)
