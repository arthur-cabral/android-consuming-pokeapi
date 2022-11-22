package com.example.projetopokemon

import com.google.gson.annotations.SerializedName

class PokemonsEntity {

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("next")
    var next: String = ""

    @SerializedName("previous")
    var previous: String = ""

    @SerializedName("results")
    lateinit var results: ArrayList<PokemonsEntity>

    @SerializedName("name")
    var name: String = ""
}