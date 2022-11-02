package com.example.composition_numbers.domain.entity

data class Question(

    val sum: Int,
    val visableNumber: Int,
    val options: List<Int>
){
    val rightAnswer:Int
    get() = sum - visableNumber
}