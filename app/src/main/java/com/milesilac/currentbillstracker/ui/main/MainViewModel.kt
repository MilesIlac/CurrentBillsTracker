package com.milesilac.currentbillstracker.ui.main

import androidx.lifecycle.ViewModel
import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE
import com.milesilac.currentbillstracker.domain.model.Bill
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    val testBillingList = listOf(
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

    val stateFlow = MutableStateFlow(testBillingList)

}