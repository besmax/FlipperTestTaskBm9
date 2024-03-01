package lionxyz.flippertesttask.database.api.repositories

import lionxyz.flippertesttask.database.api.model.LockerModel

interface KeyDbRepository {

    suspend fun getAll(): List<LockerModel>
}