package com.example.projetopokemon

import com.google.gson.annotations.SerializedName

class PokemonEntity {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("base_experience")
    var baseExperience: Int = 0
}