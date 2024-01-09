package com.sergipreferences.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sergipreferences.model.UserPreferences
import com.sergipreferences.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.flow.firstOrNull
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

    fun editUserCredentials(userName: String, phoneNumber: String) {
        viewModelScope.launch {
            preferences.editUserCredentials(UserPreferences(userName = userName, phoneNumber = phoneNumber))
            _userName.value = userName
            _phoneNumber.value = phoneNumber
        }
    }

    fun loadUserCredentials() {
        viewModelScope.launch {
            preferences.loadUserCredentials().collect() { userPreferences ->
                _userName.value = userPreferences.userName
                _phoneNumber.value = userPreferences.phoneNumber
            }
        }
    }

    fun deleteUserPreferences() {
        viewModelScope.launch {
            preferences.deleteUserPreferences()
            _userName.value = ""
            _phoneNumber.value = ""
        }
    }

    suspend fun isLoggedIn(): Boolean {
        return preferences.loadUserCredentials().firstOrNull() != null
    }
}