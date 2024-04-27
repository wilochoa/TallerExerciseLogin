package com.exercise.tallerexerciselogin.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exercise.tallerexerciselogin.viewmodels.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val loginSucess = loginViewModel.loginState.observe({})

    Column() {
        BasicTextField(value = username, onValueChange = { username = it })
        BasicTextField(value = password, onValueChange = { password = })
        Button(onClick = {
            loginViewModel.loginUser(username, password)
        }) {

        }
    }


}