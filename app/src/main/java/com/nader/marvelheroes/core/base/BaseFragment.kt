package com.nader.marvelheroes.core.base

import androidx.fragment.app.Fragment
import com.nader.marvelheroes.core.extensions.safe
import com.nader.marvelheroes.core.extensions.showToast

abstract class BaseFragment : Fragment() {

    fun handleException(exception: Exception?) {
        requireContext().showToast(
            exception?.message.safe(),
            false
        )
    }
}