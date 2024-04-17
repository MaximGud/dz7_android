package com.example.hw7_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw7_android.databinding.FragmentQuizBinding



class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val number = getAnswersByUser()
            val bundle = Bundle()
            bundle.putSerializable("number", number)
            findNavController().navigate(R.id.action_quizFragment_to_resultFragment, bundle)


        }
    }


    private fun getAnswersByUser(): Int {
        var correctAnswersCount = 0

        if (binding.question1.checkedRadioButtonId == binding.answer12.id) correctAnswersCount++
        if (binding.question2.checkedRadioButtonId == binding.answer21.id) correctAnswersCount++
        if (binding.question3.checkedRadioButtonId == binding.answer31.id) correctAnswersCount++

        return correctAnswersCount
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}