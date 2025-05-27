package com.example.pbkkallin1.P6_CurrencyConvert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pbkkallin1.ui.theme.DefaultTheme

class CurrencyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DefaultTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CurrencyConverter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

val currencyRates = mapOf(
    "IDR" to 16000.0,
    "EUR" to 0.91,
    "JPY" to 151.5,
    "INR" to 83.2,
    "AUD" to 0.64,
    "SGD" to 1.76,
    "GBP" to 1.33,
    "PESO" to 0.018,
    "RGT" to 1.23,
    "RUBEL" to 0.012,
    "YUAN" to 0.14,
)

fun convertCurrency(currency: String, amount: Double): Double {
    return currencyRates[currency]?.let { amount * it } ?: amount
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyConverter(modifier: Modifier = Modifier) {
    var dollarAmount by remember { mutableStateOf("") }
    var selectedCurrency by remember { mutableStateOf(currencyRates.keys.first()) }
    var expanded by remember { mutableStateOf(false) }

    val result = dollarAmount.toDoubleOrNull()?.let { convertCurrency(selectedCurrency, it) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = dollarAmount,
            onValueChange = { dollarAmount = it },
            label = { Text("Dollar Amount") },
            modifier = Modifier.fillMaxWidth()
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedCurrency,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select Currency") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                currencyRates.keys.forEach { currency ->
                    DropdownMenuItem(
                        text = { Text(currency) },
                        onClick = {
                            selectedCurrency = currency
                            expanded = false
                        }
                    )
                }
            }
        }

        Text(
            text = "1 USD = ${currencyRates[selectedCurrency]} ${selectedCurrency}",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = result?.let { "$dollarAmount USD =  $it $selectedCurrency" }
                ?: "Enter valid dollar amount",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyConverterPreview() {
    DefaultTheme {
        CurrencyConverter()
    }
}