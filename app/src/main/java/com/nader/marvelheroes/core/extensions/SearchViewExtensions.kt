package com.nader.marvelheroes.core.extensions

import androidx.appcompat.widget.SearchView

fun SearchView.onTextChangedListener(
    textChangeListener: ((String?) -> Unit)? = null
) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            textChangeListener?.invoke(query)
            clearFocus()
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            textChangeListener?.invoke(newText)
            return false
        }

    })
}