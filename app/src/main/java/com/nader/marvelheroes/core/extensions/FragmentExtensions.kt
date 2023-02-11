package com.nader.marvelheroes.core.extensions

import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

fun Fragment.delayOnLifecycle(
    durationInMillis: Long = 0L,
    dispatchers: CoroutineDispatcher = Dispatchers.Main,
    block: () -> Unit
): Job = requireActivity().delayOnLifecycle(durationInMillis, dispatchers, block)

fun Fragment.setWindowsColor(color: Int) {
    requireActivity().window.statusBarColor = color
}