package com.nader.marvelheroes.core.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import com.nader.marvelheroes.core.extensions.gone
import com.nader.marvelheroes.core.extensions.visible
import com.nader.marvelheroes.databinding.LayoutHeaderBinding

class HeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private lateinit var binding: LayoutHeaderBinding

    init {
        initViews()
    }

    private fun initViews() {
        binding = LayoutHeaderBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
    }


}