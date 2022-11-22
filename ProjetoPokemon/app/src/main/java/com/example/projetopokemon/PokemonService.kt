package com.example.projetopokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

//    fun list(): Call<List<PokemonEntity>>

    @GET("pokemon")
    fun allPokemons(): Call<PokemonsEntity>

    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id: Int?): Call<PokemonEntity>

    @GET("pokemon/{name}")
    fun getPokemonByName(@Path("name") name: String?): Call<PokemonEntity>
}