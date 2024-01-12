package com.sergimarrahy.gestordetareas.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.sergimarrahy.gestordetareas.database.entities.Series

interface SeriesDAO : GeneralDAO {
    @Query("SELECT * FROM series ORDER BY name")
    override fun getAllSeries(): LiveData<MutableList<Series>>

    @Query("SELECT count(*) FROM series WHERE name = :name")
    override suspend fun seriesExists(name: String): Int

    @Query("SELECT * FROM series WHERE id LIKE :id")
    override suspend fun getSeriesById(id: Long): Series

    @
}