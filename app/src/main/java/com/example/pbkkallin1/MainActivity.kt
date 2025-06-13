package com.example.pbkkallin1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pbkkallin1.P10_DessertClicker.DessertClickerActivity
import com.example.pbkkallin1.P11_ImageScroll.ImageScrollActivity
import com.example.pbkkallin1.P12_Woof.WoofActivity
import com.example.pbkkallin1.P2_HelloAndroid.HelloAndroidActivity
import com.example.pbkkallin1.P3_HappyBirthday.HappyBirthdayActivity
import com.example.pbkkallin1.P4_DiceRoller.DiceActivity
import com.example.pbkkallin1.P5_Calculator.CalculatorActivity
import com.example.pbkkallin1.P6_CurrencyConvert.CurrencyActivity
import com.example.pbkkallin1.P7_login.LoginActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
    ) {
        item {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical=64.dp).fillMaxSize()
            ) {
                Text(
                    text = "Hello Android (P2)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF00DAEE))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, HelloAndroidActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Happy Birthday (P3)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF3B99A1))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(
                                Intent(
                                    context,
                                    HappyBirthdayActivity::class.java
                                )
                            )
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Dice Roller (P4)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF00EE6B))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, DiceActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Calculator (P5)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF5CA9E3))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, CalculatorActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Currency Convert (P6)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF23A15B))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, CurrencyActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Login (P7)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF6200EE))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, LoginActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Dessert Clicker (P10)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFC9AEF1))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, DessertClickerActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Image Scroll (P11)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF34EE00))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, ImageScrollActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Woof App (P12)",
                    fontSize = 34.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFEE006F))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            context.startActivity(Intent(context, WoofActivity::class.java))
                        }
                        .padding(vertical = 16.dp)
                )
            }
        }
    }
}