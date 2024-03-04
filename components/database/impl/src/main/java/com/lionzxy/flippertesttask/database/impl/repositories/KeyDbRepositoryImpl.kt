package com.lionzxy.flippertesttask.database.impl.repositories

import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.database.impl.converters.map
import com.lionzxy.flippertesttask.database.impl.dao.KeyDao
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import lionxyz.flippertesttask.database.api.model.KeyModel
import lionxyz.flippertesttask.database.api.repositories.KeyDbRepository
import javax.inject.Inject

@ContributesBinding(AppGraph::class)
class KeyDbRepositoryImpl @Inject constructor(
    private val keyDao: KeyDao
) : KeyDbRepository {
    override suspend fun getAll(dispatcher: CoroutineDispatcher): List<KeyModel> {
        return withContext(dispatcher) {
            keyDao.getAll().map { it.map() }
        }
    }
}