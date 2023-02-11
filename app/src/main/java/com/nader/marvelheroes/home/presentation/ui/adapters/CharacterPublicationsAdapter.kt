package com.nader.marvelheroes.home.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nader.marvelheroes.databinding.ItemPublicationBinding
import com.nader.marvelheroes.databinding.ShimmerItemBinding
import com.nader.marvelheroes.home.data.model.CharacterInfoModel
import javax.inject.Inject


class CharacterPublicationsAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var isShimmering = true

    private var publications: ArrayList<CharacterInfoModel> = ArrayList()

    private var onItemClickListener: ((CharacterInfoModel) -> Unit)? = null


    fun setOnItemClickListener(listener: (CharacterInfoModel) -> Unit) {
        onItemClickListener = listener
    }

    fun addData(allPublications: ArrayList<CharacterInfoModel>) {
        publications = allPublications
        isShimmering = false
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            Type.SHIMMER -> ShimmerViewHolder(
                ShimmerItemBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> CharacterPublicationsViewHolder(
                ItemPublicationBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }


    override fun getItemCount(): Int = if (isShimmering) {
        5
    } else {
        publications.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == Type.SHIMMER) {
            (holder as ShimmerViewHolder).bind()
        } else {
            (holder as CharacterPublicationsViewHolder).bind(publications[position])
        }
    }


    inner class CharacterPublicationsViewHolder(private var binding: ItemPublicationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characterInfoModel: CharacterInfoModel) {
            binding.publication = characterInfoModel
            binding.root.setOnClickListener { onItemClickListener?.invoke(characterInfoModel) }
        }

    }

    inner class ShimmerViewHolder(private var binding: ShimmerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (isShimmering) Type.SHIMMER else Type.ITEM
    }

    private object Type {
        const val SHIMMER = 0
        const val ITEM = 1
    }
}