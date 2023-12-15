package com.sergimarrahy.sergiworkout.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommonViewModel : ViewModel() {
    private val _repsNumber = MutableLiveData(3)
    val repsNumber: LiveData<Int> = _repsNumber

    fun sumRepsNumber() {
        _repsNumber.value = _repsNumber.value!!+1
    }

    fun minusRepsNumber() {
        _repsNumber.value = _repsNumber.value!!-1
    }
}