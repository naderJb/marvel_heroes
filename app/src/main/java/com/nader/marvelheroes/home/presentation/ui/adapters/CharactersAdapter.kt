package com.nader.marvelheroes.home.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nader.marvelheroes.databinding.ItemCharacterBinding
import com.nader.marvelheroes.home.data.model.CharacterModel
import javax.inject.Inject


class CharactersAdapter @Inject constructor() :
    RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {
    private var characters: ArrayList<CharacterModel> = ArrayList()

    fun addData(allCharacters: ArrayList<CharacterModel>) {
        characters = allCharacters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    inner class CharacterViewHolder(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characterModel: CharacterModel) {
            binding.hero = characterModel
        }

    }
}