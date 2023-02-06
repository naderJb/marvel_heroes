package com.nader.marvelheroes.core.extensions

import com.nader.marvelheroes.core.exceptions.APIException
import com.nader.marvelheroes.core.model.CommonResponse
import retrofit2.Response

fun <T> Response<T>.parseErrorResponse(): String? = null

fun <R> Response<CommonResponse<R>>.dataOrException(errorMessage: String): CommonResponse<R> {
    return when (isSuccessful) {
        true -> body() ?: throw Exception(errorMessage)
        else -> throw APIException(parseErrorResponse() ?: errorMessage)
    }
}

fun <R> Response<R>.successOrException(errorMessage: String): Boolean {
    return when (isSuccessful) {
        true -> true
        else -> throw APIException(parseErrorResponse() ?: errorMessage)
    }
}
