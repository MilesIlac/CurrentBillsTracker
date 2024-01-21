package com.milesilac.currentbillstracker.ui.main.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE
import com.milesilac.currentbillstracker.domain.model.Bill

@Composable
fun MainPage(billingList: List<Bill>) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(billingList) { bill ->
                BillingCard(
                    billingCompany = bill.billingCompanyOrSector,
                    billAmount = bill.billAmount.toString(),
                    billingCoverage = bill.billCoverage
                ) {

                }
            }
        }
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Confirm"
            )
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
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        MainPage(billingList = billingList)
    }
}