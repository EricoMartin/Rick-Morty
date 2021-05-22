package com.basebox.rick_morty.entities

import com.squareup.moshi.Json

class CharacterResponse(
    @Json(name = "results")
    val characters: List<SingleCharacter>
)
