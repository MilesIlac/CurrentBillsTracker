package com.milesilac.currentbillstracker.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE
import com.milesilac.currentbillstracker.common.MONTHS
import com.milesilac.currentbillstracker.common.MONTHS_COVERAGE
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

    fun addNewBilling(oldList: List<Bill>, billToAdd: Bill) {
        performToBillingList(
            oldList = oldList,
            doStuff = { thisOldList ->
                when (
                    thisOldList.find {
                        it.billingCompanyOrSector == billToAdd.billingCompanyOrSector
                    }
                ) {
                    null -> thisOldList.add(billToAdd)
                    else -> Log.e("billAddError", "Already in list")
                }
            }
        )
    }

    fun quickUpdateBilling(oldList: List<Bill>, billToUpdate: Bill) {
        performToBillingList(
            oldList = oldList,
            doStuff = { thisOldList ->
                thisOldList.find { findBill -> findBill == billToUpdate }?.let { matchedBill ->
                    when (matchedBill.billCoverage) {
                        in MONTHS -> {
                            val matchedIndex = MONTHS.indexOf(matchedBill.billCoverage)
                            thisOldList[thisOldList.indexOf(matchedBill)] = Bill(
                                billingCompanyOrSector = matchedBill.billingCompanyOrSector,
                                billAmount = matchedBill.billAmount,
                                billCoverage = when (matchedIndex) {
                                    11 -> MONTHS[0]
                                    else -> MONTHS[matchedIndex + 1]
                                }
                            )
                        }
                        in MONTHS_COVERAGE -> {
                            val matchedIndex = MONTHS_COVERAGE.indexOf(matchedBill.billCoverage)
                            thisOldList[thisOldList.indexOf(matchedBill)] = Bill(
                                billingCompanyOrSector = matchedBill.billingCompanyOrSector,
                                billAmount = matchedBill.billAmount,
                                billCoverage = when (matchedIndex) {
                                    11 -> MONTHS_COVERAGE[0]
                                    else -> MONTHS_COVERAGE[matchedIndex + 1]
                                }
                            )
                        }
                        else -> {}
                    }
                }
            }
        )
    }

    private inline fun performToBillingList(
        oldList: List<Bill>,
        doStuff: (MutableList<Bill>) -> Unit
    ) {
        val newList = oldList.map { it.copy() }.toMutableList().apply { doStuff(this) }
        viewModelScope.launch {
            mutableBillingListStateFlow.emit(newList)
        }
    }

    companion object {
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
}