package com.sergimarrahy.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.gestordetareas.database.SeriesDataBase
import com.sergimarrahy.gestordetareas.database.dao.SeriesDAO
import com.sergimarrahy.gestordetareas.database.entities.Series
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SeriesViewModel(context: Context) : ViewModel() {
    val seriesDAO: SeriesDAO = SeriesDataBase.getInstance(context).seriesDAO()

    var seriesList: LiveData<MutableList<Series>> = MutableLiveData()
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

    fun updateSeries(series: Series, isDone: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            seriesDAO.updateSeries(series.copy(isDone = isDone))
        }
    }
}