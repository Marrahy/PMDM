package com.sergimarrahy.gestordetareas.database.dao

import androidx.lifecycle.LiveData
import com.sergimarrahy.gestordetareas.database.entities.Series

interface GeneralDAO {
    fun getAllSeries(): LiveData<MutableList<Series>>

    suspend fun seriesExists(name: String): Int

    suspend fun getSeriesById(id: Long): Series

    suspend fun addSeries(series: Series): Long

    suspend fun updateSeries(series: Series): Int

    suspend fun deleteSeries(series: Series): Int
}