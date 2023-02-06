package com.nader.marvelheroes.core.model

sealed class DataStatus {
    object DataLoading : DataStatus()
    object DataLoaded : DataStatus()
    data class DataError(val exception: Exception?) : DataStatus()
}