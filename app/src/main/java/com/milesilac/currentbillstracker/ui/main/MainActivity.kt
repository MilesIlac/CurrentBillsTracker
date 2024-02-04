package com.milesilac.currentbillstracker.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.milesilac.currentbillstracker.ui.main.MainViewModel.Companion.testBillingList
import com.milesilac.currentbillstracker.ui.main.composables.MainPage
import com.milesilac.currentbillstracker.ui.main.composables.NewBillingBottomSheet
import com.milesilac.currentbillstracker.ui.theme.CurrentBillsTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            val list by viewModel.billingListStateFlow.collectAsStateWithLifecycle()

            val sheetState = rememberModalBottomSheetState()
            var showBottomSheet by remember { mutableStateOf(false) }

            CurrentBillsTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage(
                        billingList = list,
                        onBillClick = {
                            viewModel.quickUpdateBilling(
                                oldList = list,
                                billToUpdate = it
                            )
                        },
                        onBillLongClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Bill long-clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        onAddClick = {
                            showBottomSheet = true
                        },
                        onConfirmClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Confirm clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    if (showBottomSheet) {
                        NewBillingBottomSheet(
                            sheetState = sheetState,
                            onBottomSheetDismissRequest = {
                                showBottomSheet = false
                            },
                            onAddBillingClick = {
                                viewModel.addNewBilling(
                                    oldList = list,
                                    billToAdd = it
                                )
                            }
                        )
                    }
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
                onBillClick = {},
                onBillLongClick = {},
                onAddClick = {},
                onConfirmClick = {}
            )
        }
    }
}
