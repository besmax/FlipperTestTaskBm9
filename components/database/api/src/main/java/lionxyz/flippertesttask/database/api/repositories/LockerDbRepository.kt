package lionxyz.flippertesttask.database.api.repositories

import lionxyz.flippertesttask.database.api.model.LockerModel

interface LockerDbRepository {

    suspend fun getAllArchive(): List<LockerModel>

    suspend fun getAllDevice(): List<LockerModel>

    suspend fun getAllHub(): List<LockerModel>

    suspend fun setKeyArchive(lockerNumber: Int, keyNumber: Int)

    suspend fun setKeyDevice(lockerNumber: Int, keyNumber: Int)

    suspend fun setKeyHub(lockerNumber: Int, keyNumber: Int)

}