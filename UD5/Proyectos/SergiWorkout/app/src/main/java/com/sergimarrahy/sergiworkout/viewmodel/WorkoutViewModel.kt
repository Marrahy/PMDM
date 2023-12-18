package com.sergimarrahy.sergiworkout.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergimarrahy.sergiworkout.R

class WorkoutViewModel : ViewModel(){
    private val listOfGifs: List<Int> = listOf(
        R.drawable.e1, R.drawable.e2, R.drawable.e3, R.drawable.e4, R.drawable.e5, R.drawable.e6, R.drawable.e7, R.drawable.e8
    )

    private val _exercise = MutableLiveData(getRandomGif(listOfGifs))
    val exercise: MutableLiveData<MutableMap<Int, Int>> = _exercise

}

fun getRandomGif(listOfGifs: List<Int>): MutableMap<Int, Int> {
    var randomNumber: Int
    val mapKeyToGif = mutableMapOf<Int, Int>()
    do {
        randomNumber = (0..7).random()
    } while (randomNumber in mapKeyToGif)

    mapKeyToGif[randomNumber] = listOfGifs[randomNumber]
    return mapKeyToGif
}