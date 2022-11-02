package com.example.composition_numbers.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Level : Parcelable {

    Acquaintance, Easy, Medium, Hard
}