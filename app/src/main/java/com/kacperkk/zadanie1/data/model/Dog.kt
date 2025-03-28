package com.kacperkk.zadanie1.data.model

data class Dog(
    val id: Int,
    val name: String,
    val breed: String,
    val imageUrl: String?,
    val isFavorite: Boolean
)