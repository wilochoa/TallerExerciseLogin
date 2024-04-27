package com.exercise.tallerexerciselogin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.tallerexerciselogin.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val mockUser = User("admin", "password")  // Datos mockeados
    val toastMessages = Channel<String>()

    fun loginUser(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (username == mockUser.username && password == mockUser.password) {
                toastMessages.send("Login Successful")
            } else {
                toastMessages.send("Invalid credentials")
            }
        }
    }
}