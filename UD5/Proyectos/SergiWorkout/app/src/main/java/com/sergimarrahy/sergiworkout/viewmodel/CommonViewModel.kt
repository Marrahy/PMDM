package com.sergimarrahy.sergiworkout.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommonViewModel : ViewModel() {
    private val _repsNumber = MutableLiveData(5)
    val repsNumber: MutableLiveData<Int> = _repsNumber

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    fun sumRepsNumber() {
        _repsNumber.value = _repsNumber.value!!+1
    }

    fun minusRepsNumber() {
        _repsNumber.value = _repsNumber.value!!-1
    }

    fun setUserName(userName: String) {
        _userName.value = userName
    }
}