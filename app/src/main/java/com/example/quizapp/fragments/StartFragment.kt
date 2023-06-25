package com.example.quizapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentStartBinding
import com.example.quizapp.enums.QuizCategory
import com.example.quizapp.model.LOG_TAG
import com.example.quizapp.model.QuizViewModel

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: QuizViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@StartFragment
            fragment = this@StartFragment
        }
        Log.d(LOG_TAG, "State -> $savedInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setCategory(category: QuizCategory,shuffled: Boolean) {
        sharedViewModel.setQuizCategory(category,shuffled)
    }

    fun goToNextScreen(category: QuizCategory) {
        setCategory(category,true)
        findNavController().navigate(R.id.action_startFragment_to_questionFragment)
    }
}