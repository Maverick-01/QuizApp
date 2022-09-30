package com.maverick.quizapp.network

class MainRepository constructor(private val retrofitInstance: RetrofitInstance) {
    suspend fun getQuiz() = retrofitInstance.getQuiz()
}