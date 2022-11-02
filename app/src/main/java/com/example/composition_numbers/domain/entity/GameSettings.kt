package com.example.composition_numbers.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(

    val maxSumValue: Int,
    val minCountOfRightCount: Int,
    val minPercentOfRightAnswer: Int,
    val gameTimeInSeconds:Int
):Parcelable