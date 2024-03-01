package com.lionzxy.flippertesttask.database.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lionzxy.flippertesttask.database.impl.dao.KeyDao
import com.lionzxy.flippertesttask.database.impl.dao.LockerDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysArchiveDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysDeviceDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysHubDao

@Database(
    entities = [],
    version = 1,
    exportSchema = true,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun keyDao(): KeyDao
    abstract fun lockerDao(): LockerDao
    abstract fun lockersKeysArchiveDao(): LockersKeysArchiveDao
    abstract fun lockersKeysDeviceDao(): LockersKeysDeviceDao
    abstract fun lockersKeysHubDao(): LockersKeysHubDao
}