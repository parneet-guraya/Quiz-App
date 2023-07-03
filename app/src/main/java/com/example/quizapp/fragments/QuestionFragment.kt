package com.example.quizapp.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuestionBinding
import com.example.quizapp.model.QuizViewModel
import com.google.android.material.snackbar.Snackbar


class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private var buttonState = NEXT_BUTTON_STATE
    private lateinit var countDownTimer: CountDownTimer

    private val sharedViewModel: QuizViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, true) {
            countDownTimer.cancel()
            sharedViewModel.resetQuiz()
            findNavController().navigate(R.id.action_questionFragment_to_startFragment)
        }
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@QuestionFragment
            viewModel = sharedViewModel
            fragment = this@QuestionFragment
        }
        sharedViewModel.questionCounter.observe(viewLifecycleOwner) {
            if (sharedViewModel.questionCounter.value == sharedViewModel.totalQuestions) {
                binding.button.text = getString(R.string.submit_button_text)
                buttonState = SUBMIT_BUTTON_STATE
            }
        }
        countDownTimer = object : CountDownTimer(15 * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.timer.text = String.format(
                    getString(R.string.timeout_second_text),
                    millisUntilFinished / 1000
                )
            }

            override fun onFinish() {
                Toast.makeText(binding.timer.context, "Timeout!!!", Toast.LENGTH_SHORT)
                    .show()
                sharedViewModel.submitUnanswered()
                performClick()
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // TODO: I can cancel the timer here because either way (question to result | question to start) we're cancelling it (because binding becomes null
        // TODO: so textview is not present for onTick() ) so it would be better if i cancel it in here? and if I do what about the timer state after recreation.
        // TODO: Does cancelling it here changes that?
        _binding = null
    }

    fun buttonClick() {
        if (binding.optionRadioGroup.checkedRadioButtonId == -1) {
            showNoOptionSelectedSnackBar()
        } else {
            sharedViewModel.submitAnswer(sharedViewModel.currentOption)
            performClick()
        }
    }

    private fun performClick() {
        if (buttonState == SUBMIT_BUTTON_STATE) {
            countDownTimer.cancel()
            sharedViewModel.calculateResult()
            goToResultScreen()
        } else {
            nextQuestion()
        }
    }

    private fun showNoOptionSelectedSnackBar() {
        Snackbar.make(
            binding.root,
            getString(R.string.no_options_selected_message),
            Snackbar.LENGTH_SHORT
        )
            .show()
    }

    private fun goToResultScreen() {
        findNavController().navigate(R.id.action_questionFragment_to_resultFragment)
    }

    private fun nextQuestion() {
        binding.optionRadioGroup.clearCheck()
        sharedViewModel.nextQuestion()
        countDownTimer.start()
    }

    companion object {
        private const val SUBMIT_BUTTON_STATE = "SUBMIT_BUTTON_STATE"
        private const val NEXT_BUTTON_STATE = "NEXT_BUTTON_STATE"
    }
}