package com.sergimarrahy.sergilist.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergimarrahy.sergilist.Model.WowCharacter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WowCharacterViewModel : ViewModel() {
    private val _wowCharacters = MutableLiveData<List<WowCharacter>>()
    val wowCharacters: LiveData<List<WowCharacter>> = _wowCharacters

    private val _selectedWowCharacter = MutableLiveData<WowCharacter>()
    val selectedWowCharacter: LiveData<WowCharacter> = _selectedWowCharacter

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000)
            _wowCharacters.value = WowCharacter.getData()
            _isLoading.value = false
        }
    }

    fun deleteWowCharacter(wowCharacter: WowCharacter) {
        _wowCharacters.value = _wowCharacters.value?.filter { it != wowCharacter }
    }

    fun onWowCharacterClicked(wowCharacter: WowCharacter) {
        _selectedWowCharacter.value = wowCharacter
    }

    fun onFavoriteClicked() {
        _selectedWowCharacter.value?.favorite = !_selectedWowCharacter.value?.favorite!!

        _wowCharacters.value?.map {
            if (it == _selectedWowCharacter.value)
                it.favorite = !it.favorite
        }
    }
}