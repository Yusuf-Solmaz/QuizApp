package com.yusuf.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.yusuf.quizapp.R
import com.yusuf.quizapp.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: ResultFragmentArgs by navArgs()

        val cNu= bundle.correctNu
        val wNu= 5-cNu

        binding.textView4.text = "Correct: $cNu    Inorrect: $wNu"

        binding.textView5.text = "%${cNu*20} Success"

        binding.button2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_resultFragment_to_questionsFragment)
        }
    }

}