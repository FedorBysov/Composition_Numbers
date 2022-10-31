package com.example.composition_numbers.domain.entity

data class GameResult(

    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestion: Int,
    val gameSettings: GameSettings
)