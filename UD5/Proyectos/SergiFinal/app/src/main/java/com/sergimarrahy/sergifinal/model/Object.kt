package com.sergimarrahy.sergifinal.model

data class Series (
    val name: String = "",
    val numberOfChapters: Int = 0,
    val studio: String = "",
    val favorite: Boolean = false
) {
    companion object {
        fun getData(): List<Series> {

        }
    }
}