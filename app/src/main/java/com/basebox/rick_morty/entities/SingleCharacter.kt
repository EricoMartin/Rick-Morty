package com.basebox.rick_morty.entities

import com.squareup.moshi.Json

data class SingleCharacter(
    @Json(name = "name") val name: String,
    @Json(name = "species") val specie: String,
    @Json(name = "status") val status: String,
    @Json(name = "url") val image: String
)