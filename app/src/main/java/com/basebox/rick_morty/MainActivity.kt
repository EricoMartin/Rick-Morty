package com.basebox.rick_morty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.basebox.rick_morty.adapter.CharacterAdapter
import com.basebox.rick_morty.databinding.ActivityMainBinding
import com.basebox.rick_morty.entities.SingleCharacter
import com.basebox.rick_morty.network.Api
import com.basebox.rick_morty.repository.Repository
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    var characters = mutableListOf<SingleCharacter>()

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this,
            MainViewModelFactory(Repository(Api.apiService))).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding?.recycler?.layoutManager = LinearLayoutManager(this)
        viewModel.allCharacterLiveData.observe(this,
                Observer {
                    characters.addAll(it)
                })
    }

    override fun onResume() {
        super.onResume()

        val adapter = CharacterAdapter(characters)

        binding?.recycler?.adapter = adapter

       (binding?.recycler?.adapter as CharacterAdapter).notifyDataSetChanged()
    }
}