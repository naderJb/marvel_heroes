package com.nader.marvelheroes.core.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.nader.marvelheroes.R
import com.nader.marvelheroes.databinding.CustomToastLayoutBinding


fun Context.isOnline(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        else -> false
    }
}

fun Context.getFloatFromDp(dp: Int): Float = (dp * this.resources.displayMetrics.density)

fun Context.showToast(message: String, success: Boolean = true) {
    val binding = CustomToastLayoutBinding.inflate(
        LayoutInflater.from(this)
    )
    binding.tvToastMsg.setCompoundDrawablesWithIntrinsicBounds(
        ContextCompat.getDrawable(
            this,
            if (success) R.drawable.ic_toast_success else R.drawable.ic_toast_error
        ), null, null, null
    )
    binding.cardToast.setBackgroundColor(
        ContextCompat.getColor(
            this,
            if (success) R.color.softGreen else R.color.grapefruit
        )
    )
    binding.tvToastMsg.text = message
    Toast(this).apply {
        duration = Toast.LENGTH_SHORT
        view = binding.root
    }.show()
}