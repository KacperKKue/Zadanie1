package com.kacperkk.zadanie1.data.model

data class Dog(
    val id: Int,
    val name: String,
    val breed: String,
    val isFavorite: Boolean = false
)