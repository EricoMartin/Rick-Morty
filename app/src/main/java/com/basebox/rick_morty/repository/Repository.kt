package com.basebox.rick_morty.repository

import com.basebox.rick_morty.network.ApiService

class Repository(private val apiService: ApiService) {
    suspend fun getCharacters() = apiService.getCharacters()
}