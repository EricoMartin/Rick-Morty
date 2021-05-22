package com.basebox.rick_morty.network

import com.basebox.rick_morty.entities.CharacterResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private  val BASE_URL = "https://rickandmortyapi.com/api/"
interface ApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}

    val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val retrofit: Retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(
        BASE_URL).build()
    object Api{
        val apiService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }