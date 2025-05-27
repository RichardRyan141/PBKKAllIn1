package com.example.pbkkallin1.P7_login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pbkkallin1.MainActivity
import com.example.pbkkallin1.R
import com.example.pbkkallin1.data.Users

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var loginError by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(150.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Masukkan Email") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Masukkan Password") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (passwordVisible) "🙈" else "👁"
                Text(
                    text = icon,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .clickable { passwordVisible = !passwordVisible }
                        .padding(end = 8.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Lupa Password?",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable {
                }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val matchedUser = Users.find { it.email == email && it.password == password }

                if (matchedUser != null) {
                    val intent = Intent(context, HelloActivity::class.java).apply {
                        putExtra("email", matchedUser.email)
                        putExtra("username", matchedUser.username)
                    }
                    context.startActivity(intent)
                    (context as? ComponentActivity)?.finish()
                } else {
                    loginError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        if (loginError) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Email atau password salah",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "atau Buat Akun Baru?",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clickable {
                }
        )

        Spacer(modifier = Modifier.height(48.dp))
    }
}
