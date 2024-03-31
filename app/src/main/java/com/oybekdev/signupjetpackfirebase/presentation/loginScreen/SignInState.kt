package com.oybekdev.signupjetpackfirebase.presentation.loginScreen

data class SignInState(
    val isloading:Boolean = false,
    val isSuccess :String? = "",
    val isError:String? = ""
)