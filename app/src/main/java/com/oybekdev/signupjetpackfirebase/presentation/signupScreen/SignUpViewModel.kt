package com.oybekdev.signupjetpackfirebase.presentation.signupScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oybekdev.signupjetpackfirebase.data.AuthRepository
import com.oybekdev.signupjetpackfirebase.presentation.loginScreen.SignInState
import com.oybekdev.signupjetpackfirebase.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
    ):ViewModel() {

    val _signUpState = Channel<SignInState>()
    val signUpState = _signUpState.receiveAsFlow()

    fun registerUser(email: String, password: String) = viewModelScope.launch {
        repository.registerUser(email,password).collect{result ->
            when(result){
                is Resource.Error -> {
                    _signUpState.send(SignInState(isSuccess = "Sign In Success"))
                }
                is Resource.Loading -> {
                    _signUpState.send(SignInState(isloading = true))
                }
                is Resource.Success -> {
                    _signUpState.send(SignInState(isError = result.message))
                }
            }
        }
    }
}