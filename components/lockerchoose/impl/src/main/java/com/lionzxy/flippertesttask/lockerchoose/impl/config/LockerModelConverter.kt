package com.lionzxy.flippertesttask.lockerchoose.impl.config

import lionxyz.flippertesttask.database.api.model.LockerModel

fun LockerModel.map() = com.lionzxy.flippertesttask.lockerchoose.api.model.LockerModel(
    lockerNumber = number,
    keyNumber = keyNumber
)