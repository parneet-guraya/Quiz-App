package com.example.quizapp.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.DataSource
import com.example.quizapp.enums.QuizCategory

const val LOG_TAG = "MYCUSTOMLOGTAG"

class QuizViewModel : ViewModel() {
    private var questionList = listOf<Question>()
    private val resultList = mutableListOf<Result>()

    private val _questionCounter = MutableLiveData<Int>()
    val questionCounter: LiveData<Int> = _questionCounter

    // Shared ViewModel
    private val _question = MutableLiveData<Question?>()
    val question: LiveData<Question?> = _question

    var totalQuestions: Int = 0
    var totalMarks: Int = 0

    /*TODO: Here when the value is set it's never nullified because it is only being
       overwritten and since without any option chosen we cannot submit the answer
         which will prevent from submitting previous question value.
         So, option needed to be chosen if we want to submit answer which anyways overwrite the value
         hence we get latest value always. So, currently we're not resetting it anywhere.
         Look into if we ever need it.*/

    var _currentOption: String? = null
    val currentOption get() = _currentOption!!

    private var _correctAnswers = MutableLiveData<Int>()
    val correctAnswers: LiveData<Int> = _correctAnswers

    private val _marksScored = MutableLiveData<Int>()
    val marksScored: LiveData<Int> = _marksScored


    init {
        resetQuiz()
    }

    fun submitAnswer(option: String) {
        val isCorrect = if (option == _question.value!!.options.correctOption) {
            CORRECT
        } else {
            INCORRECT
        }
        storeAnswer(isCorrect)
    }

    fun submitUnanswered() {
        storeAnswer(UNANSWERED)
    }

    private fun storeAnswer(isCorrect: String) {
        resultList.add(Result(isCorrect))
    }

    // TODO: why it give 0 when using simple instance properties instead of livedata
    fun calculateResult() {
//        Log.d(LOG_TAG, "Result List size:${resultList.size}")
//        resultList.forEachIndexed { index, result ->
//            Log.d(LOG_TAG, "Result[$index]:${result.isCorrect}")
//            if (result.isCorrect == CORRECT) {
//                _correctAnswers.value = correctAnswers.value!!.inc()
//            }
//        }
        for (result: Result in resultList) {
            Log.d(LOG_TAG, "Result: ")
            if (result.isCorrect == CORRECT) {
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
        _questionCounter.value = 0
        _question.value = null
        _correctAnswers.value = 0
        _marksScored.value = 0
        totalQuestions = 0
        totalMarks = 0
        resultList.clear()
    }

    fun setQuizCategory(category: QuizCategory, shuffled: Boolean) {
        val list = when (category) {
            QuizCategory.MATHEMATICS -> DataSource.mathematicsQuestions
            QuizCategory.SCIENCE -> DataSource.scienceQuestions
            QuizCategory.GENERAL_KNOWLEDGE -> DataSource.gkQuestions
            QuizCategory.ANDROID -> DataSource.androidQuestions
        }
        questionList = if (shuffled) {
            list.shuffled()
        } else {
            list
        }
        setupListState()
    }

    private fun setupListState() {
        Log.d(LOG_TAG, "$totalQuestions")
        totalQuestions = questionList.size
        totalMarks = EACH_CORRECT_MARK * totalQuestions
        _questionCounter.value = 1
        _question.value = questionList[_questionCounter.value!!.minus(1)]
        Log.d(LOG_TAG, "$totalQuestions")
    }

    companion object {
        private const val CORRECT = "CORRECT"
        private const val INCORRECT = "INCORRECT"
        private const val UNANSWERED = "UNANSWERED"
        const val EACH_CORRECT_MARK = 10
    }
}