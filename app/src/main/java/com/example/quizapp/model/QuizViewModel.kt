package com.example.quizapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.DataSource

const val LOG_TAG = "MYCUSTOMLOGTAG"

class QuizViewModel : ViewModel() {
    private val questionList = DataSource.questionsList
    private val resultList = mutableListOf<Result>()

    val totalQuestions = questionList.size
    val totalMarks = EACH_CORRECT_MARK * totalQuestions

    private val _questionCounter = MutableLiveData<Int>()
    val questionCounter: LiveData<Int> = _questionCounter

    // Shared ViewModel
    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question> = _question

    private val _isCorrect = MutableLiveData<String>()
    val isCorrect: LiveData<String> = _isCorrect

    init {
        resetQuiz()
    }

    fun submitAnswer(option: String) {
        if (option == _question.value!!.options.correctOption) {
            _isCorrect.value = CORRECT
        } else {
            _isCorrect.value = INCORRECT
        }
        storeAnswer(_isCorrect.value!!)
    }
    private fun storeAnswer(isCorrect: String){
        resultList.add(Result(isCorrect))
    }
    fun nextQuestion() {
        if (questionCounter.value!! < totalQuestions) {
            _question.value = questionList[questionCounter.value!!]
            _questionCounter.value = _questionCounter.value!!.inc()
        }
    }


    fun resetQuiz() {
        _questionCounter.value = 1
        _question.value = questionList[_questionCounter.value!!.minus(1)]
    }

    companion object {
        private const val CORRECT = "CORRECT"
        private const val INCORRECT = "INCORRECT"
        const val EACH_CORRECT_MARK = 10
    }
}