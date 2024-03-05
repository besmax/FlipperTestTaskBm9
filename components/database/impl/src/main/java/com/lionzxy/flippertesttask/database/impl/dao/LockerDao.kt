package com.lionzxy.flippertesttask.database.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.lionzxy.flippertesttask.database.impl.model.LockerEntity

@Dao
interface LockerDao {
    @Query("SELECT * FROM lockers_table")
    suspend fun getAll(): List<LockerEntity>

    @Query("SELECT * FROM lockers_table WHERE number=:number")
    suspend fun getByNumber(number: Int): LockerEntity

    @Upsert
    suspend fun update(locker: LockerEntity)

    @Insert
    suspend fun insertAll(lockers: List<LockerEntity>)
}