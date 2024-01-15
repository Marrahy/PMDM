package com.sergimarrahy.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.sergifinal.model.User
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.random.Random

class CommonViewModel(context: Context) : ViewModel() {
    private val preferences = AppPreferences(context)

    private val _id = MutableLiveData<Int>()

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onUserNameChange(userName: String) {
        _userName.value = userName
    }

    fun onUserPhoneNumberChange(phoneNumber: String) {
        _phoneNumber.value = phoneNumber
    }

    fun onUserEmailChange(email: String) {
        _email.value = email
    }

    fun saveUserCredentials(userName: String, phoneNumber: String, email: String) {
        viewModelScope.launch {
            preferences.saveUser(User(userId = (1..100).random(), userName = userName, phoneNumber = phoneNumber, email = email))
            _userName.value = userName
            _phoneNumber.value = phoneNumber
        }
    }

    fun loadUser() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.loadUser().collect() { user ->
                _id.postValue(user.userId)
                _userName.postValue(user.userName)
                _phoneNumber.postValue(user.phoneNumber)
                _email.postValue(user.email)
            }
        }
    }

    fun deleteUserPreferences() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.deleteUserPreferences()
        }
    }
}