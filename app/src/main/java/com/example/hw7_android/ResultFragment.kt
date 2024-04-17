package com.example.hw7_android

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hw7_android.databinding.FragmentResultBinding


class ResultFragment<ResultFragmentArgs> : Fragment() {

    private val args: ResultFragmentArgs by navArgs()
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userDataFromBundle = requireArguments().getSerializable("number")

        binding.result.text = "$userDataFromBundle/3"

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_quizFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}