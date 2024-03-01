package com.lionzxy.flippertesttask.database.impl.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.lionzxy.flippertesttask.database.impl.model.LockerEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysDeviceEntity

@Dao
interface LockersKeysHubDao {

    @Query("SELECT lockers_table.number, keys_table.number FROM lockers_table " +
            "LEFT JOIN lockers_keys_hub_table ON lockers_table.number = lockers_keys_hub_table.locker_id " +
            "LEFT JOIN keys_table ON lockers_keys_hub_table.key_id = keys_table.number")
    suspend fun getAllLockers(): List<LockerEntity>

    @Query("SELECT lockers_table.number, keys_table.number FROM lockers_table " +
            "LEFT JOIN lockers_keys_hub_table ON lockers_table.number = lockers_keys_hub_table.locker_id " +
            "LEFT JOIN keys_table ON lockers_keys_hub_table.key_id = keys_table.number")
    suspend fun get(): LockersKeysDeviceEntity?

    @Upsert
    suspend fun insert(entity: LockersKeysDeviceEntity)
}