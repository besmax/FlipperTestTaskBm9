package com.lionzxy.flippertesttask.lockerchoose.api.model

sealed interface LockerChooseScreenState {

    data object Loading : LockerChooseScreenState

    data class Content(
        val lockers: List<LockerModel>
    ) : LockerChooseScreenState

}