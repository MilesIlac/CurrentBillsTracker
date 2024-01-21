package com.milesilac.currentbillstracker.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE
import com.milesilac.currentbillstracker.domain.model.Bill
import com.milesilac.currentbillstracker.ui.main.composables.MainPage
import com.milesilac.currentbillstracker.ui.theme.CurrentBillsTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrentBillsTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage(
                        billingList = testBillingList(),
                        onBillingClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Bill clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        onBillingLongClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Bill long-clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        onAddClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Add clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        onConfirmClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Confirm clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        CurrentBillsTrackerTheme {
            MainPage(
                billingList = testBillingList(),
                onBillingClick = {},
                onBillingLongClick = {},
                onAddClick = {},
                onConfirmClick = {}
            )
        }
    }
}

private fun testBillingList() = listOf(
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