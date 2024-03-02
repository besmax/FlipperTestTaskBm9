package com.lionzxy.flippertesttask.database.impl.repositories

import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.database.impl.converters.map
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysArchiveDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysDeviceDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysHubDao
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysArchiveEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysDeviceEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysHubEntity
import com.squareup.anvil.annotations.ContributesBinding
import lionxyz.flippertesttask.database.api.model.LockerModel
import lionxyz.flippertesttask.database.api.repositories.LockerDbRepository
import javax.inject.Inject

@ContributesBinding(AppGraph::class)
class LockerDbRepositoryImpl @Inject constructor(
    private val lockersKeysArchiveDao: LockersKeysArchiveDao,
    private val lockersKeysDeviceDao: LockersKeysDeviceDao,
    private val lockersKeysHubDao: LockersKeysHubDao,
) : LockerDbRepository {

    override suspend fun getAllArchive(): List<LockerModel> {
        return lockersKeysArchiveDao.getAllLockers().map { it.map() }
    }

    override suspend fun getAllDevice(): List<LockerModel> {
        return lockersKeysDeviceDao.getAllLockers().map { it.map() }
    }

    override suspend fun getAllHub(): List<LockerModel> {
        return lockersKeysHubDao.getAllLockers().map { it.map() }
    }

    override suspend fun setKeyArchive(lockerNumber: Int, keyNumber: Int) {
        val currentEntity = lockersKeysArchiveDao.get(lockerNumber, keyNumber)
        if (currentEntity == null) {
            lockersKeysArchiveDao.insert(
                LockersKeysArchiveEntity(
                    lockerId = lockerNumber,
                    keyId = keyNumber
                )
            )
        } else {
            lockersKeysArchiveDao.insert(currentEntity.copy(keyId = keyNumber))
        }
    }

    override suspend fun setKeyDevice(lockerNumber: Int, keyNumber: Int) {
        val currentEntity = lockersKeysDeviceDao.get(lockerNumber, keyNumber)
        if (currentEntity == null) {
            lockersKeysDeviceDao.insert(
                LockersKeysDeviceEntity(
                    lockerId = lockerNumber,
                    keyId = keyNumber
                )
            )
        } else {
            lockersKeysDeviceDao.insert(currentEntity.copy(keyId = keyNumber))
        }
    }

    override suspend fun setKeyHub(lockerNumber: Int, keyNumber: Int) {
        val currentEntity = lockersKeysHubDao.get(lockerNumber, keyNumber)
        if (currentEntity == null) {
            lockersKeysHubDao.insert(
                LockersKeysHubEntity(
                    lockerId = lockerNumber,
                    keyId = keyNumber
                )
            )
        } else {
            lockersKeysHubDao.insert(currentEntity.copy(keyId = keyNumber))
        }
    }


}