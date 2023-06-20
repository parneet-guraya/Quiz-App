package com.example.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuestionBinding
import com.example.quizapp.model.QuizViewModel
import com.google.android.material.snackbar.Snackbar


class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel:QuizViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@QuestionFragment
            viewModel = sharedViewModel
            fragment = this@QuestionFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun nextQuestion(){
        if(binding.optionRadioGroup.checkedRadioButtonId == -1){
            Snackbar.make(binding.root,getString(R.string.no_options_selected_message),Snackbar.LENGTH_SHORT)
                .show()
        }else{
            binding.optionRadioGroup.clearCheck()
            binding.answer.text = null
            sharedViewModel.nextQuestion()
        }
    }
}