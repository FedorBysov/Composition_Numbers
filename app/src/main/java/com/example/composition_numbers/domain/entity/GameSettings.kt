package com.example.composition_numbers.domain.entity

import java.io.Serializable

data class GameSettings(

    val maxSumValue: Int,
    val minCountOfRightCount: Int,
    val minPercentOfRightAnswer: Int,
    val gameTimeSeconds: Int

): Serializable