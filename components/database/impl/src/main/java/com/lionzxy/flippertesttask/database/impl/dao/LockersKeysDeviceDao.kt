package com.lionzxy.flippertesttask.database.impl.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.lionzxy.flippertesttask.database.impl.model.LockerEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysDeviceEntity

@Dao
interface LockersKeysDeviceDao {

    @Query("""SELECT locker_id AS number, key_id AS key_number FROM lockers_keys_device_table""")
    suspend fun getAllLockers(): List<LockerEntity>

    @Query("SELECT lockers_keys_device_table.id, lockers_keys_device_table.locker_id, lockers_keys_device_table.key_id FROM lockers_table " +
            "LEFT JOIN lockers_keys_device_table ON lockers_table.number = lockers_keys_device_table.locker_id " +
            "LEFT JOIN keys_table ON lockers_keys_device_table.key_id = keys_table.number " +
            "WHERE lockers_keys_device_table.locker_id = :lockerNumber")
    suspend fun get(lockerNumber: Int): LockersKeysDeviceEntity?

    @Upsert
    suspend fun insert(entity: LockersKeysDeviceEntity)
}