package com.nader.marvelheroes.home.presentation.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily
import com.google.gson.Gson
import com.nader.marvelheroes.core.extensions.getFloatFromDp
import com.nader.marvelheroes.core.extensions.safe
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

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characterModel: CharacterModel) {
            Log.e("nano", Gson().toJson(characterModel))
            with(binding) {
                tvCharacterName.text = characterModel.name.safe()
                tvCharacterRealName.text = characterModel.name.safe()
                tvCharacterDescription.text = characterModel.description.safe()
                Glide
                    .with(root.context)
                    .load(characterModel.thumbnail?.let { it.path + "." + it.extension })
                    .placeholder(com.nader.marvelheroes.R.drawable.ic_search)
                    .error(com.nader.marvelheroes.R.drawable.ic_search)
                    .fallback(com.nader.marvelheroes.R.drawable.ic_search)
                    .into(ivHero)


                root.context.getFloatFromDp(20).let { radius ->
                    binding.ivHero.shapeAppearanceModel = binding.ivHero.shapeAppearanceModel
                        .toBuilder()
                        .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                        .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
                        .build()
                }
            }


        }

    }
}