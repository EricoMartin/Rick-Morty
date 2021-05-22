package com.basebox.rick_morty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.basebox.rick_morty.repository.Repository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private  val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }else{
            throw IllegalArgumentException("UNKNOWN CLASS")
        }
    }
}