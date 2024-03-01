package com.lionzxy.flippertesttask.database.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.lionzxy.flippertesttask.database.impl.model.KeyEntity

@Dao
interface KeyDao {

    @Query("SELECT * FROM keys_table")
    suspend fun getAll(): List<KeyEntity>

    @Query("SELECT * FROM keys_table WHERE number=:number")
    suspend fun getByNumber(number: Int): KeyEntity

    @Upsert
    suspend fun update(key: KeyEntity)

    @Insert
    suspend fun insertAll(keys: List<KeyEntity>)

}