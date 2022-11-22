package com.example.projetopokemon

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        private fun getRetrofitInstance(): Retrofit {
            var http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized){
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun <S> createService(c: Class<S>): S{
            return getRetrofitInstance().create(c)
        }
    }

}