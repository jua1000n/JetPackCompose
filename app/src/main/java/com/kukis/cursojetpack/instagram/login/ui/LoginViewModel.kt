package com.kukis.cursojetpack.instagram.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kukis.cursojetpack.instagram.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase:LoginUseCase): ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChange(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun onLoginSelected() {
        _isLoading.value = true
        viewModelScope.launch {
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                //Navegar a la siguente pantalla
                Log.i("kukis", "result OK")
            }
            _isLoading.value = false
        }
    }
}