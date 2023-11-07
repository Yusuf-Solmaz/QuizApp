package com.yusuf.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yusuf.quizapp.R
import com.yusuf.quizapp.databinding.FragmentQuestionsBinding
import com.yusuf.quizapp.db.Flag
import com.yusuf.quizapp.db.FlagDao

class QuestionsFragment : Fragment() {

    private lateinit var questions: ArrayList<Flag>
    private lateinit var wrongAnswers: ArrayList<Flag>
    private lateinit var correctAnswer: Flag
    private lateinit var options: HashSet<Flag>
    private  var dao = FlagDao(requireContext())

    private var questionNu=0
    private var correctQuestions=0
    private var inCorrectQuestions=0

    private lateinit var binding: FragmentQuestionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        
    }

}