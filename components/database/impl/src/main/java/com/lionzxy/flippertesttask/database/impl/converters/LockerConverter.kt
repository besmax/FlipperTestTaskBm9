package com.lionzxy.flippertesttask.database.impl.converters

import com.lionzxy.flippertesttask.database.impl.model.LockerEntity
import lionxyz.flippertesttask.database.api.model.LockerModel

fun LockerEntity.map(): LockerModel = LockerModel(
    number = number,
    keyNumber = keyNumber,
)

