package com.milesilac.currentbillstracker.ui.main

import com.milesilac.currentbillstracker.domain.model.Bill


sealed class BillState<T>(val newList: T? = null) {
    class AddBillingError<T>: BillState<T>()
    class UpdatedList<T>(newList: T? = null): BillState<T>(newList = newList)
}

data class BillUIState(
    val newList: List<Bill> = listOf(),
    val errorMessage: Error? = null
) {
    sealed class Error {
        data object AlreadyInList: Error()
    }
}