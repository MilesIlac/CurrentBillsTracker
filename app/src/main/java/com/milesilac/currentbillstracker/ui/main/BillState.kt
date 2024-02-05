package com.milesilac.currentbillstracker.ui.main

import com.milesilac.currentbillstracker.domain.model.Bill


sealed class BillState<T>(
    val newList: T? = null,
    val errorMessage: Error? = null,
    val checkBill: Bill? = null,
) {
    class AddBillingError<T>(
        errorMessage: Error? = null,
        checkBill: Bill? = null
    ): BillState<T>(errorMessage = errorMessage, checkBill = checkBill)
    class UpdatedList<T>(newList: T? = null): BillState<T>(newList = newList)
}

data class BillUIState(
    val newList: List<Bill> = listOf(),
    val errorMessage: Error? = null,
    val checkBill: Bill? = null
)

sealed class Error {
    data object AlreadyInList: Error()
}