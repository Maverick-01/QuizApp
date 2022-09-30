package com.maverick.quizapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maverick.quizapp.model.QuizModel
import com.maverick.quizapp.network.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val error = MutableLiveData<String>()
    val result = MutableLiveData<QuizModel>()
    fun getAllQuiz() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getQuiz()
            if (response.isSuccessful){
                result.postValue(response.body())
            }
            else{
                error.postValue(response.message())
            }
        }
    }
}