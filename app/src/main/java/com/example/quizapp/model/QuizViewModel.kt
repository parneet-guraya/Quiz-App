package com.example.quizapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.DataSource

const val LOG_TAG = "MYCUSTOMLOGTAG"

class QuizViewModel : ViewModel() {
    private val questionList = DataSource.questionsList
    private val resultList = mutableListOf<Result>()

    private val _questionCounter = MutableLiveData<Int>()
    val questionCounter: LiveData<Int> = _questionCounter

    // Shared ViewModel
    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question> = _question

    private val _isCorrect = MutableLiveData<String?>()
    val isCorrect: LiveData<String?> = _isCorrect

    val totalQuestions = questionList.size
    val totalMarks = EACH_CORRECT_MARK * totalQuestions

    private var _correctAnswers = MutableLiveData<Int>(0)
    val correctAnswers:LiveData<Int> = _correctAnswers

    private val _marksScored = MutableLiveData<Int>()
    val marksScored:LiveData<Int> = _marksScored


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

    // TODO: why it give 0 when using simple instance properties instead of livedata
    fun calculateResult(){
        for (result:Result in resultList){
            if(result.isCorrect == CORRECT){
               _correctAnswers.value = correctAnswers.value!!.inc()
            }
        }
        _marksScored.value = correctAnswers.value!!.times(EACH_CORRECT_MARK)
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
        _isCorrect.value = null
        _correctAnswers.value = 0
        _marksScored.value = 0
        resultList.clear()
    }

    companion object {
        private const val CORRECT = "CORRECT"
        private const val INCORRECT = "INCORRECT"
        const val EACH_CORRECT_MARK = 10
    }
}