package com.example.pbkkallin1.P5_Calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorScreen()
}

@Composable
fun CalculatorScreen() {
    var equation by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun calc() {
        try {
            val exp = Expression(equation)
            val value = exp.calculate()
            result = if (value.isNaN()) {
                "= Error"
            } else {
                "= ${DecimalFormat("0.######").format(value)}"
            }
        } catch (e: Exception) {
            result = "= $e"
        }
    }

    fun addToEq(s: String) {
        equation += s
        calc()
    }

    fun clearEq() {
        equation = ""
        result = ""
    }

    fun dropLast() {
        if (equation.isNotEmpty()) {
            equation = equation.dropLast(1)
            calc()
        }
    }

    fun equals() {
        calc()
        if(result != "= Error") {
            equation = result.substring(2)
            result = ""
        }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = if (equation.isEmpty()) "" else equation,
            fontSize = 28.sp,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Text(
            text = if (result.isEmpty()) "" else result,
            fontSize = 28.sp,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF706E6E),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 2.dp,
            color = Color.LightGray
        )

        val buttonRows = listOf(
            listOf("C", "(", ")", "/"),
            listOf("7", "8", "9", "*"),
            listOf("4", "5", "6", "+"),
            listOf("1", "2", "3", "-"),
            listOf("AC", "0", ".", "=")
        )

        buttonRows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { label ->
                    addButton(
                        text = label,
                        color = if(label >= "0" && label <= "9") Color.Black else Color(0xFFFF9800),
                        action = {
                            when (label) {
                                "C" -> clearEq()
                                "AC" -> dropLast()
                                "=" -> equals()
                                else -> addToEq(label)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun addButton(
    text: String,
    color: Color,
    action: () -> Unit
) {
    Button(
        onClick = action,
        modifier = Modifier
            .padding(4.dp)
            .shadow(8.dp, shape = RoundedCornerShape(50))
            .size(78.dp), // Circular buttons
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFAFAFA),
            contentColor = color
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 6.dp)
    ) {
        if (text == "AC") {
            Icon(
                imageVector = Icons.Default.Backspace,
                contentDescription = "Backspace",
                tint = color,
                modifier = Modifier.size(32.dp)
            )
        } else {
            Text(
                text = text,
                fontSize = 32.sp
            )
        }
    }
}
