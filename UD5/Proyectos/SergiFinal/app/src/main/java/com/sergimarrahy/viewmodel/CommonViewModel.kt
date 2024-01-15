package com.sergimarrahy.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.sergifinal.model.User
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommonViewModel(context: Context) : ViewModel() {
    private val preferences = AppPreferences(context)

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    fun onUserNameChange(userName: String) {
        _userName.value = userName
    }

    fun saveUserName(userName: String) {
        viewModelScope.launch {
            preferences.saveUser(User(userName = userName))
            _userName.postValue("")
        }
    }
}