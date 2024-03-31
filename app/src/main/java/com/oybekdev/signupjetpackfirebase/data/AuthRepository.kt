package com.oybekdev.signupjetpackfirebase.data

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.oybekdev.signupjetpackfirebase.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email:String, password:String):Flow<Resource<AuthResult>>
    fun registerUser(email:String, password:String):Flow<Resource<AuthResult>>
    fun googleSignIn(credintial:AuthCredential):Flow<Resource<AuthResult>>
}