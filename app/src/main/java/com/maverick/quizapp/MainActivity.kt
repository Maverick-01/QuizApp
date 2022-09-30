package com.maverick.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.maverick.quizapp.databinding.ActivityMainBinding
import com.maverick.quizapp.network.MainRepository
import com.maverick.quizapp.network.RetrofitInstance
import com.maverick.quizapp.viewmodel.MainViewModel
import com.maverick.quizapp.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
        val repository = MainRepository(retrofitInstance)
        viewModel = ViewModelProvider(this,ViewModelFactory(repository))[MainViewModel::class.java]
        viewModel.result.observe(this) {
            Log.e("response", it.toString())
        }
        viewModel.getAllQuiz()
//        val intent = startActivity(Intent(this,QuizActivity::class.java))
//        finish()
    }
}