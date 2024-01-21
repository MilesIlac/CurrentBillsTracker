package com.milesilac.currentbillstracker.ui.main.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BillingCard(
    billingCompany: String,
    billAmount: String,
    billingCoverage: String,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    Box (
        modifier = Modifier
            .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(4.dp))
            .padding(4.dp)
            .combinedClickable(
                onClick = onClick,
                onLongClick = onLongClick
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(weight = 1F),
                text = billingCompany,
                fontSize = 14.sp,
                textAlign = TextAlign.Start
            )
            Text(
                modifier = Modifier.weight(weight = 1F),
                text = billAmount,
                fontSize = 14.sp,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.weight(weight = 1F),
                text = billingCoverage,
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BillingCardPreview() {
    BillingCard(
        billingCompany = DEFAULT_BILLING_COMPANY,
        billAmount = "P500.00",
        billingCoverage = "February - September",
        onClick = {},
        onLongClick = {}
    )
}