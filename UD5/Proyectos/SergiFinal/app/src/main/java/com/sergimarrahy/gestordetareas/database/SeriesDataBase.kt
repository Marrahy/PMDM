package com.sergimarrahy.gestordetareas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sergimarrahy.gestordetareas.database.dao.SeriesDAO
import com.sergimarrahy.gestordetareas.database.entities.Series

@Database(entities = arrayOf(Series::class), version = 1)
abstract class SeriesDataBase : RoomDatabase() {
    abstract fun seriesDAO(): SeriesDAO

    companion object {
        private var instance: SeriesDataBase? = null

        fun getInstance(context: Context): SeriesDataBase {
            return instance ?: Room.databaseBuilder(context, SeriesDataBase::class.java, "series-db")
                .build()
                .also { instance = it }
        }
    }
}