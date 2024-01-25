package com.milesilac.currentbillstracker.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.milesilac.currentbillstracker.ui.main.composables.MainPage
import com.milesilac.currentbillstracker.ui.theme.CurrentBillsTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            CurrentBillsTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage(
                        billingList = viewModel.stateFlow.collectAsState().value,
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
    val viewModel: MainViewModel = hiltViewModel()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        CurrentBillsTrackerTheme {
            MainPage(
                billingList = viewModel.testBillingList,
                onBillingClick = {},
                onBillingLongClick = {},
                onAddClick = {},
                onConfirmClick = {}
            )
        }
    }
}
