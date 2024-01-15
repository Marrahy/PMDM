package com.sergimarrahy.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.gestordetareas.database.SeriesDataBase
import com.sergimarrahy.gestordetareas.database.dao.SeriesDAO
import com.sergimarrahy.gestordetareas.database.entities.Series
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(context: Context) : ViewModel() {
    private val preferences = AppPreferences(context)
    val seriesDAO: SeriesDAO = SeriesDataBase.getInstance(context).seriesDAO()
    var seriesList: LiveData<MutableList<Series>> = MutableLiveData()

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> = _userName

    fun loadUser() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.loadUser().collect() { user ->
                _userName.postValue(user.userName)
            }
        }
    }

    fun deleteUserPreferences() {
        viewModelScope.launch(Dispatchers.IO) {
            preferences.deleteUserPreferences()
        }
    }

    fun getAllSeries() {
        viewModelScope.launch(Dispatchers.IO) {
            seriesList = seriesDAO.getAllSeries()
        }
    }

    fun addSeries(seriesName: String, description: String, chapterNumber: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            if (seriesDAO.seriesExists(seriesName) == 0) {
                seriesDAO.addSeries(Series(name = seriesName, description = description, chapterNumber = chapterNumber))
            }
        }
    }

    fun deleteSeries(series: Series) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesDAO.deleteSeries(series)
        }
    }

    fun getSelectedSeries(series: Series) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesDAO.getSeriesByName(series.name)
        }
    }

}