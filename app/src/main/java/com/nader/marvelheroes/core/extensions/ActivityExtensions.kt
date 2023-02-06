package com.nader.marvelheroes.core.extensions

import android.app.Activity
import kotlinx.coroutines.*

fun Activity.delayOnLifecycle(
    durationInMillis: Long = 0L,
    dispatchers: CoroutineDispatcher = Dispatchers.Main,
    block: () -> Unit
): Job = CoroutineScope(dispatchers).launch {
    delay(durationInMillis)
    block.invoke()
}