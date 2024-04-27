package com.exercise.tallerexerciselogin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.exercise.tallerexerciselogin.screens.LoginScreen
import com.exercise.tallerexerciselogin.ui.theme.TallerExerciseLoginTheme
import com.exercise.tallerexerciselogin.viewmodels.LoginViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: LoginViewModel = viewModel()
            val context = LocalContext.current

            // Observe Toast messages
            LaunchedEffect(key1 = context) {
                viewModel.toastMessages.receiveAsFlow().collectLatest { message ->
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
            }

            LoginScreen(viewModel)
        }
    }
}

