package com.lionzxy.flippertesttask.database.impl.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("lockers_keys_device_table")
data class LockersKeysDeviceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("locker_id") val lockerId: Int,
    @ColumnInfo("key_id") val keyId: Int,
)
