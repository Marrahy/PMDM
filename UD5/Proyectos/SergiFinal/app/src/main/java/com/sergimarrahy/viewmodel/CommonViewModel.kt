package com.sergimarrahy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences

class CommonViewModel(application: Application) : AndroidViewModel(application) {
    private val preferenecs = AppPreferences(application.applicationContext)

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _objectName = MutableLiveData<String>()
    val objectName: LiveData<String> = _objectName
}