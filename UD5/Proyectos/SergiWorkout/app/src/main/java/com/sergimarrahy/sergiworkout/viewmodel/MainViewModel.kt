package com.sergimarrahy.sergiworkout.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val listOfMotivationalSentece: List<String> = listOf(
        "¡Activa tu día!", "¡Rompe barreras hoy!", "¡Hazlo por ti!", "¡Sé imparable!", "¡Transforma, no conformes!"
    )
    private val _motivationalSentences = MutableLiveData(setMotivationSentence(listOfMotivationalSentece))
    val motivationSentence: LiveData<String> = _motivationalSentences

    private fun setMotivationSentence(listOfMotivationalSentence: List<String>): String {
        val randomNumber = (0..4).random()
        return listOfMotivationalSentence[randomNumber]
    }

}