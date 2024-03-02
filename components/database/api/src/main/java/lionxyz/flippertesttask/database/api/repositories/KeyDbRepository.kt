package lionxyz.flippertesttask.database.api.repositories

import lionxyz.flippertesttask.database.api.model.KeyModel

interface KeyDbRepository {

    suspend fun getAll(): List<KeyModel>
}