package com.sergimarrahy.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.sergifinal.model.User
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CommonViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application.applicationContext)

    private var numberId = 0;

    private val _id = MutableLiveData<Int>()
    val id: LiveData<Int> = _id

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    private val _seriesName = MutableLiveData<String>()
    val series: LiveData<String> = _seriesName

    private val _chapterNumber = MutableLiveData<Int>()
    val chapterNumber: LiveData<Int> = _chapterNumber

    fun onUserNameChange(userName: String) {
        _userName.value = userName
    }

    fun onSeriesNameChange(seriesName: String) {
        _seriesName.value = seriesName
    }

    fun onChapterNumberChange(chapterNumber: Int) {
        _chapterNumber.value = chapterNumber
    }

    fun saveUser(userName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            numberId += 1
            preferences.saveUser(User(userId = numberId, userName))
            _seriesName.postValue("")
        }
    }

    fun loadUser() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.loadUser().collect() { user ->
                _id.postValue(user.userId)
                _userName.postValue(user.userName)
            }
        }
    }

    fun deleteUserPreferences() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.deleteUserPreferences()
        }
    }
}