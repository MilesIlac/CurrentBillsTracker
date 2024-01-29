package com.milesilac.currentbillstracker.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE
import com.milesilac.currentbillstracker.domain.model.Bill
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    private val mutableBillingListStateFlow = MutableStateFlow<List<Bill>>(emptyList())
    val billingListStateFlow = mutableBillingListStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            mutableBillingListStateFlow.emit(testBillingList())
        }
    }

    fun addNewBilling(oldList: List<Bill>) {
        val mutableList = oldList.map {
            it.copy()
        }.toMutableList().apply {
            add(
                Bill(
                    billingCompanyOrSector = DEFAULT_BILLING_COMPANY,
                    billAmount = 500.00F,
                    billCoverage = "January - February"
                )
            )
        }
        viewModelScope.launch {
            mutableBillingListStateFlow.emit(
                mutableList
            )
        }
    }

    fun testBillingList() = listOf(
        Bill(
            billingCompanyOrSector = DEFAULT_BILLING_COMPANY,
            billAmount = 500.00F,
            billCoverage = "January - February"
        ),
        Bill(
            billingCompanyOrSector = "Pampanga Electric Co. II",
            billAmount = 4000.00F,
            billCoverage = DEFAULT_COVERAGE
        ),
        Bill(
            billingCompanyOrSector = "PAG-IBIG Housing Loan",
            billAmount = 5500.00F,
            billCoverage = DEFAULT_COVERAGE
        ),
        Bill(
            billingCompanyOrSector = "Home Owners' Association",
            billAmount = 400.00F,
            billCoverage = DEFAULT_COVERAGE
        ),
        Bill(
            billingCompanyOrSector = "Internet Service Provider",
            billAmount = 3000.00F,
            billCoverage = DEFAULT_COVERAGE
        ),
    )
}