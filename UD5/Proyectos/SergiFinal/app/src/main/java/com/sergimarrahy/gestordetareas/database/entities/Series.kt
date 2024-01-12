package com.sergimarrahy.gestordetareas.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Series(
    @PrimaryKey var name: String = "",
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "chapter_number") val chapterNumber: Int = 0
)