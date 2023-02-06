package com.nader.marvelheroes.core.model

open class SingleEvent<out T>(private val content: T) {

    private var hasBeenHandled = false


    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}
