package com.lionzxy.flippertesttask.database.impl.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.lionzxy.flippertesttask.database.impl.model.LockerEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysArchiveEntity

@Dao
interface LockersKeysArchiveDao {

    @Query("SELECT lockers_table.number, keys_table.number FROM lockers_table " +
            "LEFT JOIN lockers_keys_archive_table ON lockers_table.number = lockers_keys_archive_table.locker_id " +
            "LEFT JOIN keys_table ON lockers_keys_archive_table.key_id = keys_table.number")
    suspend fun getAllLockers(): List<LockerEntity>

    @Query("SELECT lockers_keys_archive_table.id, lockers_keys_archive_table.locker_id, lockers_keys_archive_table.key_id FROM lockers_table " +
            "LEFT JOIN lockers_keys_archive_table ON lockers_table.number = lockers_keys_archive_table.locker_id " +
            "LEFT JOIN keys_table ON lockers_keys_archive_table.key_id = keys_table.number " +
            "WHERE lockers_keys_archive_table.locker_id = :lockerNumber AND lockers_keys_archive_table.key_id = :keyNumber")
    suspend fun get(lockerNumber: Int, keyNumber: Int): LockersKeysArchiveEntity?

    @Upsert
    suspend fun insert(entity: LockersKeysArchiveEntity)
}