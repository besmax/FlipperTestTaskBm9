package com.lionzxy.flippertesttask.database.impl.repositories

import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.database.impl.converters.map
import com.lionzxy.flippertesttask.database.impl.dao.LockerDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysArchiveDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysDeviceDao
import com.lionzxy.flippertesttask.database.impl.dao.LockersKeysHubDao
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysArchiveEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysDeviceEntity
import com.lionzxy.flippertesttask.database.impl.model.LockersKeysHubEntity
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import lionxyz.flippertesttask.database.api.model.LockerModel
import lionxyz.flippertesttask.database.api.repositories.LockerDbRepository
import javax.inject.Inject

@ContributesBinding(AppGraph::class)
class LockerDbRepositoryImpl @Inject constructor(
    private val lockerDao: LockerDao,
    private val lockersKeysArchiveDao: LockersKeysArchiveDao,
    private val lockersKeysDeviceDao: LockersKeysDeviceDao,
    private val lockersKeysHubDao: LockersKeysHubDao,
) : LockerDbRepository {

    override suspend fun getAllArchive(dispatcher: CoroutineDispatcher): List<LockerModel> {
        val archiveLockers = withContext(dispatcher) {
            lockersKeysArchiveDao.getAllLockers().map { it.map() }
        }
        val lockers = withContext(dispatcher) {
            lockerDao.getAll().map { it.map() }
        }
        return mergeLists(lockers, archiveLockers)
    }

    override suspend fun getAllDevice(dispatcher: CoroutineDispatcher): List<LockerModel> {
        val deviceLockers =
            withContext(dispatcher) { lockersKeysDeviceDao.getAllLockers().map { it.map() } }
        val lockers = withContext(dispatcher) { lockerDao.getAll().map { it.map() } }
        return mergeLists(lockers, deviceLockers)
    }

    override suspend fun getAllHub(dispatcher: CoroutineDispatcher): List<LockerModel> {
        val hubLockers =
            withContext(dispatcher) { lockersKeysHubDao.getAllLockers().map { it.map() } }
        val lockers = withContext(dispatcher) { lockerDao.getAll().map { it.map() } }
        return mergeLists(lockers, hubLockers)
    }

    override suspend fun setKeyArchive(
        lockerNumber: Int,
        keyNumber: Int,
        dispatcher: CoroutineDispatcher
    ) = withContext(dispatcher) {
        val currentEntity = lockersKeysArchiveDao.get(lockerNumber)
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

    override suspend fun setKeyDevice(
        lockerNumber: Int,
        keyNumber: Int,
        dispatcher: CoroutineDispatcher
    ) = withContext(dispatcher) {
        val currentEntity = lockersKeysDeviceDao.get(lockerNumber)
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

    override suspend fun setKeyHub(
        lockerNumber: Int,
        keyNumber: Int,
        dispatcher: CoroutineDispatcher
    ) = withContext(dispatcher) {
        val currentEntity = lockersKeysHubDao.get(lockerNumber)
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

    private fun mergeLists(
        main: List<LockerModel>,
        secondary: List<LockerModel>
    ): List<LockerModel> {
        return if (secondary.isEmpty()) {
            main
        } else {
            val resultList = main.toMutableList()
            secondary.forEach { secondaryLocker ->
                val locker = resultList.find { it.number == secondaryLocker.number }
                val index = resultList.indexOf(locker)
                if (locker != null) {
                    resultList[index] = locker.copy(keyNumber = secondaryLocker.keyNumber)
                }
            }
            resultList
        }
    }

}