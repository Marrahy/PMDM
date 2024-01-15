package com.sergimarrahy.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.gestordetareas.database.SeriesDataBase
import com.sergimarrahy.gestordetareas.database.dao.SeriesDAO
import com.sergimarrahy.gestordetareas.database.entities.Series
import com.sergimarrahy.sergifinal.preferences.apppreferences.AppPreferences
import kotlinx.coroutines.launch

class SplashViewModel(context: Context) : ViewModel() {
    val seriesDAO: SeriesDAO = SeriesDataBase.getInstance(context).seriesDAO()
    private val preferences = AppPreferences(context)

    suspend fun loadSeriesSampleList() {
        val listOfSampleSeries = listOf(
            Series("Las Super Nenas", "Cuatro chicas con superpoderes que luchan contra el crimen.", 156),
            Series("Ed, Edd y Eddy", "Tres amigos que viven en un barrio suburbano.", 425),
            Series("Courage the Cowardly Dog", "Un perro cobarde que vive con su dueña, Muriel, y su suegro, Eustace.", 104 ),
            Series("Samurai Jack", "Un samurái que viaja en el tiempo para derrotar a Aku.", 65),
            Series("Steven Universe", "Una historia sobre la amistad, la familia y la autoaceptación.", 260),
            Series ("Adventure Time", "Una historia sobre Finn, un niño humano, y Jake, su perro mágico.", 283),
            Series ("Regular Show", "Una historia sobre dos amigos que trabajan en un parque de atracciones.", 261),
            Series ("Over the Garden Wall", "Una historia sobre dos hermanos que se pierden en un bosque encantado.", 10),
            Series ("Infinity Train", "Una historia sobre una chica que viaja a través de un tren infinito.", 30)
        )
        for (series in listOfSampleSeries) {
            seriesDAO.addSeries(series)
        }
    }

    suspend fun isDataStored(onCollected: (Boolean) -> Unit) {
        viewModelScope.launch() {
            preferences.isDataStored().collect {
                onCollected(it)
            }
        }
    }

}
