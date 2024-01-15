package com.sergimarrahy.gestordetareas.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sergimarrahy.gestordetareas.database.entities.Series

@Dao
interface SeriesDAO : GeneralDAO {
    @Query("SELECT * FROM series ORDER BY name")
    override fun getAllSeries(): LiveData<MutableList<Series>>

    @Query("SELECT * FROM series WHERE name = :name")
    override suspend fun getSeriesByName(name: String): Series

    @Query("SELECT count(*) FROM series WHERE name = :name")
    override suspend fun seriesExists(name: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun addSeries(series: Series): Long

    @Update
    override suspend fun updateSeries(series: Series): Int

    @Delete
    override suspend fun deleteSeries(series: Series): Int
}