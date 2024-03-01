package lionxyz.flippertesttask.database.api.repositories

import lionxyz.flippertesttask.database.api.model.KeyModel

interface LockerDbRepository {

    suspend fun getAll(): List<KeyModel>

    suspend fun setKey(lockerNumber: Int, keyNumber: Int)
}