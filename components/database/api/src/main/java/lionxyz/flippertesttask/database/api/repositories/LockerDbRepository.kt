package lionxyz.flippertesttask.database.api.repositories

import kotlinx.coroutines.CoroutineDispatcher
import lionxyz.flippertesttask.database.api.model.LockerModel

interface LockerDbRepository {

    suspend fun getAllArchive(dispatcher: CoroutineDispatcher): List<LockerModel>

    suspend fun getAllDevice(dispatcher: CoroutineDispatcher): List<LockerModel>

    suspend fun getAllHub(dispatcher: CoroutineDispatcher): List<LockerModel>

    suspend fun setKeyArchive(lockerNumber: Int, keyNumber: Int, dispatcher: CoroutineDispatcher)

    suspend fun setKeyDevice(lockerNumber: Int, keyNumber: Int, dispatcher: CoroutineDispatcher)

    suspend fun setKeyHub(lockerNumber: Int, keyNumber: Int, dispatcher: CoroutineDispatcher)

}