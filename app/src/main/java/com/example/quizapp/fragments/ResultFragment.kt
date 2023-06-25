package com.example.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.model.QuizViewModel

class ResultFragment : Fragment() {

    private val sharedViewModel: QuizViewModel by activityViewModels()

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            sharedViewModel.resetQuiz()
            findNavController().navigate(R.id.action_resultFragment_to_startFragment)
        }
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_result,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = this@ResultFragment
            fragment = this@ResultFragment
            viewModel = sharedViewModel
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun restartQuiz(){
        //TODO: Add restart functionality!
        sharedViewModel.resetQuiz()
        findNavController().navigate(R.id.action_resultFragment_to_startFragment)
    }
}