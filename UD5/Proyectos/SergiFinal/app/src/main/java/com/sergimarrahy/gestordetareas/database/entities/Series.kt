package com.sergimarrahy.gestordetareas.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "series")
data class Series(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "chapter_number") val chapterNumber: String = "",
)
