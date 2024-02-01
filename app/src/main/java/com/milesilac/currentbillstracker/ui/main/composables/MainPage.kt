package com.milesilac.currentbillstracker.ui.main.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.milesilac.currentbillstracker.R
import com.milesilac.currentbillstracker.domain.model.Bill
import com.milesilac.currentbillstracker.ui.main.MainViewModel

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    billingList: List<Bill>,
    onBillingClick: () -> Unit,
    onBillingLongClick: () -> Unit,
    onAddClick: () -> Unit,
    onConfirmClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .weight(1F)
                .wrapContentHeight(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(billingList) { bill ->
                key(bill.billingCompanyOrSector) {
                    BillingCard(
                        billingCompany = bill.billingCompanyOrSector,
                        billAmount = bill.billAmount.toString(),
                        billingCoverage = bill.billCoverage,
                        onClick = onBillingClick,
                        onLongClick = onBillingLongClick
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.8F),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onAddClick
            ) {
                Text(
                    text = stringResource(id = R.string.txt_add_billing)
                )
            }
            Button(
                onClick = onConfirmClick
            ) {
                Text(
                    text = stringResource(id = R.string.txt_confirm)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    val viewModel: MainViewModel = hiltViewModel()
    val billingList = viewModel.testBillingList()
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        MainPage(
            billingList = billingList,
            onBillingClick = {},
            onBillingLongClick = {},
            onAddClick = {},
            onConfirmClick = {}
        )
    }
}