package com.basebox.rick_morty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.basebox.rick_morty.databinding.ListItemBinding
import com.basebox.rick_morty.entities.SingleCharacter

class CharacterAdapter(private val characters: List<SingleCharacter>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(private val binding: ListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bindItem(character: SingleCharacter){
            binding.image.load(character.image)
            binding.textViewName.text = character.name
            binding.textViewSpecie.text = character.specie
            binding.textViewStatus.text = character.status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val cat = characters[position]
        return holder.bindItem(cat)
        }
    }