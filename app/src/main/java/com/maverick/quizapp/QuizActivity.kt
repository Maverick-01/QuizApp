package com.maverick.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.maverick.quizapp.databinding.ActivityQuizActivtyBinding
import com.maverick.quizapp.network.RetrofitInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_quiz_activty)

//        val api = RetrofitInstance.api
//        actionBar?.hide()

//        GlobalScope.launch {
//            val result = api.getQuiz()
//            binding.apply {
//                question.text = result.body()?.result?.questions?.get(2)?.lable
//            }
//        }
    }
}