package com.lionzxy.flippertesttask.keychoose.impl.converters

import lionxyz.flippertesttask.database.api.model.KeyModel


fun KeyModel.map() = com.lionzxy.flippertesttask.keychooseapi.model.KeyModel(
    number = number
)