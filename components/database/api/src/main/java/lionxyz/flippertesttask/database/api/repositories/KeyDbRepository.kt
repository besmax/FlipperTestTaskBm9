package lionxyz.flippertesttask.database.api.repositories

import kotlinx.coroutines.CoroutineDispatcher
import lionxyz.flippertesttask.database.api.model.KeyModel

interface KeyDbRepository {

    suspend fun getAll(dispatcher: CoroutineDispatcher): List<KeyModel>
}