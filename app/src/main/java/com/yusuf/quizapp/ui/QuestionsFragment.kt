package com.yusuf.quizapp.ui

import android.os.Bundle
import android.util.Log
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
    private lateinit var dao: FlagDao

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
        dao = FlagDao(view.context)

        questions = dao.get5Flag()
        getQuestion()

        //Log.e("QUESTİONS",questions.toString())
    }

    private fun getQuestion(){
        binding.textView3.text = "${questionNu+1}. Question"
        correctAnswer = questions.get(questionNu)

        Log.e("INFO",correctAnswer.flag_url
        )


        binding.imageView.setImageResource(resources.getIdentifier(correctAnswer.flag_url,"drawable","com.yusuf.quizapp"))

    }

}