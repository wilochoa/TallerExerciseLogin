package com.exercise.tallerexerciselogin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exercise.tallerexerciselogin.data.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val mockUser = User("user","password")
    private val _loginState  = MutableLiveData<Boolean>()
    val loginState:LiveData<Boolean> = _loginState

    fun loginUser(userName:String, password:String){

        viewModelScope.launch {
            val result  = withContext(Dispatchers.IO) {
                if(userName == mockUser.username && password == mockUser.password)
                    _loginState.postValue(true)
                else _loginState.postValue(false)
            }
        }
    }
}