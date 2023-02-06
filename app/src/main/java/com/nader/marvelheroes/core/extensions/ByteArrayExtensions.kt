package com.nader.marvelheroes.core.extensions

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}