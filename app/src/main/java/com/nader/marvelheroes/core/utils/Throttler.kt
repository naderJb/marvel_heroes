package com.nader.marvelheroes.core.utils

import kotlinx.coroutines.*

class Throttler(
    private var durationInMillis: Long = THROTTLE_DURATION,
    private var dispatchers: CoroutineDispatcher = Dispatchers.Main
) {
    private var throttler: Job? = null

    fun throttle(block: () -> Unit) {
        throttler?.cancel()
        throttler = CoroutineScope(dispatchers).launch {
            delay(durationInMillis)
            block.invoke()
        }
    }


    companion object {
        private const val THROTTLE_DURATION = 500L
    }
}