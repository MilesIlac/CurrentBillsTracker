package com.milesilac.currentbillstracker.ui.main.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE
import com.milesilac.currentbillstracker.domain.model.Bill

@Composable
fun MainPage(billingList: List<Bill>) {
    LazyColumn {
        items(billingList) { bill ->
            BillingCard(
                billingCompany = bill.billingCompanyOrSector,
                billAmount = bill.billAmount.toString(),
                billingCoverage = bill.billCoverage
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    val billingList = listOf(
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
    MainPage(billingList = billingList)
}