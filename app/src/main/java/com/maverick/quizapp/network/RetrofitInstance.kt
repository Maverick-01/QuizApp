package com.maverick.quizapp.network

import com.maverick.quizapp.model.QuizModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitInstance {
    @GET("?quiz=true")
    suspend fun getQuiz(): Response<QuizModel>

    companion object {
        private var retrofitInstance: RetrofitInstance? = null
        fun getRetrofitInstance(): RetrofitInstance {
            if (retrofitInstance == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://b4e7d359-c58f-4aa3-a314-726b3baa3852.mock.pstmn.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitInstance = retrofit.create(RetrofitInstance::class.java)
            }
            return retrofitInstance!!
        }
    }
}