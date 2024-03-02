package com.lionzxy.flippertesttask.database.impl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lionzxy.flippertesttask.database.impl.dao.KeyDao
import com.lionzxy.flippertesttask.database.impl.dao.LockerDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysArchiveDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysDeviceDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysHubDao
import com.lionzxy.flippertesttask.database.impl.model.KeyEntity
import com.lionzxy.flippertesttask.database.impl.model.LockerEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysArchiveEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysDeviceEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysHubEntity

@Database(
    entities = [
        KeyEntity::class,
        LockerEntity::class,
        LockersKeysArchiveEntity::class,
        LockersKeysDeviceEntity::class,
        LockersKeysHubEntity::class
    ],
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