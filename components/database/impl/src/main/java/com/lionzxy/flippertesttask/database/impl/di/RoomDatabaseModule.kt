package com.lionzxy.flippertesttask.database.impl.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.database.impl.AppDatabase
import com.lionzxy.flippertesttask.database.impl.MockData
import com.lionzxy.flippertesttask.database.impl.dao.KeyDao
import com.lionzxy.flippertesttask.database.impl.dao.LockerDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysArchiveDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysDeviceDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysHubDao
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Singleton

private const val DATABASE_NAME = "flipper_test_task_database"

@Module
@ContributesTo(AppGraph::class)
class RoomDatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            //insert lockers and keys in db
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(SupervisorJob()).launch(Dispatchers.IO) {
                        provideRoomDatabase(context).lockerDao().insertAll(MockData.lockers)
                        provideRoomDatabase(context).keyDao().insertAll(MockData.keys)
                    }
                }
            })
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideKeyDao(database: AppDatabase): KeyDao {
        return database.keyDao()
    }

    @Provides
    fun provideLockerDao(database: AppDatabase): LockerDao {
        return database.lockerDao()
    }

    @Provides
    fun provideLockersKeysArchiveDao(database: AppDatabase): LockersKeysArchiveDao {
        return database.lockersKeysArchiveDao()
    }

    @Provides
    fun provideLockersKeysDeviceDao(database: AppDatabase): LockersKeysDeviceDao {
        return database.lockersKeysDeviceDao()
    }

    @Provides
    fun provideLockersKeysHubDao(database: AppDatabase): LockersKeysHubDao {
        return database.lockersKeysHubDao()
    }
}