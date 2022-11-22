package com.example.projetopokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.projetopokemon.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener(this)

    }
    private fun getPokemonById(id: Int){
        val service = RetrofitClient.createService(PokemonService::class.java)
        val call: Call<PokemonEntity> = service.getPokemonById(id)
        call.enqueue(object : Callback<PokemonEntity> {
            override fun onResponse(call: Call<PokemonEntity>, response: Response<PokemonEntity>) {
                val pokemon = response.body()
                if (pokemon != null) {
                    binding.namePokemon.text = pokemon.name
                }
            }

            override fun onFailure(call: Call<PokemonEntity>, t: Throwable) {
                println("A aplicação falhou, throw $t, call $call")
            }

        })
    }

    private fun getPokemonByName(name: String){
        val service = RetrofitClient.createService(PokemonService::class.java)
        val call: Call<PokemonEntity> = service.getPokemonByName(name)
        call.enqueue(object : Callback<PokemonEntity> {
            override fun onResponse(call: Call<PokemonEntity>, response: Response<PokemonEntity>) {
                val pokemon = response.body()
                if (pokemon != null) {
                    binding.namePokemon.text = pokemon.name
                    binding.numberPokemon.text = pokemon.id.toString()
                }
            }

            override fun onFailure(call: Call<PokemonEntity>, t: Throwable) {
                println("A aplicação falhou, throw $t, call $call")
            }

        })
    }

    override fun onClick(view: View?) {
        if (binding.editQuery.text == null){
            Toast.makeText(this, "Preencha o campo", Toast.LENGTH_LONG).show()
            return
        }
//        getPokemonById(binding.editQuery.text.toString().toInt())
        getPokemonByName(binding.editQuery.text.toString())
    }

}


