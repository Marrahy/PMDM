package com.sergimarrahy.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.gestordetareas.database.SeriesDataBase
import com.sergimarrahy.gestordetareas.database.dao.SeriesDAO
import com.sergimarrahy.gestordetareas.database.entities.Series
import com.sergimarrahy.sergifinal.model.User
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val preferences = AppPreferences(application)
    var seriesList: LiveData<MutableList<Series>> = MutableLiveData()
    private val seriesDAO: SeriesDAO = SeriesDataBase.getInstance(application).seriesDAO()


    private val _userName = MutableLiveData<String>()
    var userName: LiveData<String> = _userName

    private val _selectedSeries = MutableLiveData<Series>()
    var selectedSeries: LiveData<Series> = _selectedSeries

    fun onUserNameChange(userName: String) {
        _userName.value = userName
    }

    fun saveUserName(userName: String) {
        viewModelScope.launch {
            preferences.saveUser(User(userName = userName))
            _userName.postValue("")
        }
    }

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

    suspend fun isDataStored(onCollected: (Boolean) -> Unit) {
        viewModelScope.launch() {
            preferences.isDataStored().collect {
                onCollected(it)
            }
        }
    }

    fun getAllSeries() {
        viewModelScope.launch(Dispatchers.IO) {
            seriesList = seriesDAO.getAllSeries()
        }
    }

    fun addSeries(seriesName: String, description: String, chapterNumber: String) {
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

    fun onSeriesClicked(series: Series) {
        _selectedSeries.value = series
    }

    suspend fun loadSeriesSampleList() {
        val listOfSampleSeries = listOf(
            Series(0, "Las Super Nenas", "Cuatro chicas con superpoderes que luchan contra el crimen.", "156"),
            Series(1, "Ed, Edd y Eddy", "Tres amigos que viven en un barrio suburbano.", "425"),
            Series(2, "Courage the Cowardly Dog", "Un perro cobarde que vive con su dueña, Muriel, y su suegro, Eustace.", "104"),
            Series(3, "Samurai Jack", "Un samurái que viaja en el tiempo para derrotar a Aku.", "65"),
            Series(4, "Steven Universe", "Una historia sobre la amistad, la familia y la autoaceptación.", "260"),
            Series(5, "Adventure Time", "Una historia sobre Finn, un niño humano, y Jake, su perro mágico.", "283"),
            Series(6, "Regular Show", "Una historia sobre dos amigos que trabajan en un parque de atracciones.", "261"),
            Series(7, "Over the Garden Wall", "Una historia sobre dos hermanos que se pierden en un bosque encantado.", "10"),
            Series(8, "Infinity Train", "Una historia sobre una chica que viaja a través de un tren infinito.", "30")
        )
        for (series in listOfSampleSeries) {
            seriesDAO.addSeries(series)
        }
    }

}