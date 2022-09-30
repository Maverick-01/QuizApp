package com.maverick.quizapp.model

data class Result(
    val questions: List<Question>,
    val timeInMinutes: Int
)