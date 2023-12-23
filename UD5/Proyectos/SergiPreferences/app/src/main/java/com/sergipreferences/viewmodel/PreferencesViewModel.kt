package com.sergipreferences.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sergipreferences.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.launch

class PreferencesViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application.applicationContext)

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    fun onUserNameChange(userName: String) {
        _userName.value = userName
    }

    fun onUserPhoneNumberChange(userPhoneNumber: String) {
        _phoneNumber.value = userPhoneNumber
    }

    fun saveUserCredentials(userName: String, phoneNumber: String) {
        viewModelScope.launch {
            preferences.saveUserCredentials(userName, phoneNumber)
            _userName.value = ""
            _phoneNumber.value = ""
        }
    }

    fun userIsRegistered(): Boolean {
        var userIsRegistered = false
        viewModelScope.launch {
            preferences.loadUserCredentials().collect() {
                if (it.isNotBlank()) userIsRegistered = true
            }
        }
        return userIsRegistered
    }

//    fun deleteAllData(userName: String, phoneNumber: String) {
//        viewModelScope.launch {
//            preferences.deleteAllData(userName, phoneNumber)
//            _userName.value = ""
//            _phoneNumber.value = ""
//        }
//    }
}