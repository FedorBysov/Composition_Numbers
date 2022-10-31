package com.example.composition_numbers.domain.entity

data class Question(

    val sum: Int,
    val visableNumber: Int,
    val options: List<Int>
)