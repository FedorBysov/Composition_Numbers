package com.example.composition_numbers.domain.entity

data class GameSettings(

    val maxSumValue: Int,
    val minCountOfRightCount: Int,
    val minPercentOfRightAnswer: Int,
    val gameTimeSeconds: Int

)