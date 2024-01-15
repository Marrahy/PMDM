package com.sergimarrahy.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddScreenViewModel() : ViewModel() {
    private val _seriesName = MutableLiveData<String>()
    val seriesName: LiveData<String> = _seriesName

    fun onSeriesNameChange(seriesName: String) {
        _seriesName.value = seriesName
    }

    fun onSeriesNameDelete() {
        _seriesName.value = ""
    }
}