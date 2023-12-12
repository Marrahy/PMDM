package com.sergimarrahy.sergiworkout.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommonViewModel : ViewModel() {
    private val _repsNumber = MutableLiveData<Int>()
    val repsNumber: LiveData<Int> = _repsNumber
}