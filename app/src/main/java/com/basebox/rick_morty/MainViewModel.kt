package com.basebox.rick_morty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basebox.rick_morty.entities.SingleCharacter
import com.basebox.rick_morty.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    private val TAG = "MainViewModel"
    private val characterLiveData = MutableLiveData<List<SingleCharacter>>()
    val allCharacterLiveData: LiveData<List<SingleCharacter>>
        get() = characterLiveData

    init {
        getCharacters()
    }
    private fun getCharacters(){
        viewModelScope.launch{
            try {
                characterLiveData.value = repository.getCharacters().characters
                Log.d(TAG, "Value of Characters: ${characterLiveData.value}")
            }catch (e: Exception ){
                Log.e(TAG, "Error: ${e.message.toString()}")
                e.printStackTrace()
            }

        }

    }
}