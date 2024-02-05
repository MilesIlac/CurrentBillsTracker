package com.milesilac.currentbillstracker.ui.main.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.milesilac.currentbillstracker.R
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE
import com.milesilac.currentbillstracker.domain.model.Bill

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewBillingBottomSheet(
    sheetState: SheetState = rememberModalBottomSheetState(),
    onBottomSheetDismissRequest: () -> Unit,
    onAddBillingClick: (Bill) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onBottomSheetDismissRequest,
        sheetState = sheetState
    ) {
        NewBillingBottomSheetContent(
            onAddBillingClick = onAddBillingClick
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NewBillingBottomSheetPreview(
) {
    ModalBottomSheet(
        onDismissRequest = {}
    ) {
        NewBillingBottomSheetContent(
            onAddBillingClick = {}
        )
    }
}

@Composable
fun NewBillingBottomSheetContent(
    onAddBillingClick: (Bill) -> Unit,
    defaultInputBillingCompany: String = "Internet Service Provider",
    defaultInputBillingAmount: String = "3000.00",
    defaultInputBillingCoverage: String = DEFAULT_COVERAGE,
) {
    var inputBillingCompanyText by remember { mutableStateOf(defaultInputBillingCompany) }
    var inputBillingAmountText by remember { mutableStateOf(defaultInputBillingAmount) }
    var inputBillingCoverageText by remember { mutableStateOf(defaultInputBillingCoverage) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = inputBillingCompanyText,
            onValueChange = { inputBillingCompanyText = it },
            label = { Text("Billing Company") }
        )
        OutlinedTextField(
            value = inputBillingAmountText,
            onValueChange = { inputBillingAmountText = it },
            label = { Text("Billing Amount") }
        )
        OutlinedTextField(
            value = inputBillingCoverageText,
            onValueChange = { inputBillingCoverageText = it },
            label = { Text("Billing Coverage") }
        )
        Button(
            onClick = {
                onAddBillingClick(
                    Bill(
                        billingCompanyOrSector = inputBillingCompanyText,
                        billAmount = inputBillingAmountText.toFloat(),
                        billCoverage = inputBillingCoverageText
                    )
                )
            }
        ) {
            Text(
                text = stringResource(id = R.string.txt_add_billing)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewBillingBottomSheetContentPreview(
) {
    NewBillingBottomSheetContent(
        onAddBillingClick = {}
    )
}