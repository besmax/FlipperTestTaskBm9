package com.lionzxy.flippertesttask.database.impl.converters

import com.lionzxy.flippertesttask.database.impl.model.KeyEntity
import lionxyz.flippertesttask.database.api.model.KeyModel

fun KeyEntity.map(): KeyModel = KeyModel(
    number = number,
)