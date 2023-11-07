package com.yusuf.quizapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
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
    private var correctQuestionNu=0
    private var inCorrectQuestionNu=0

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

        binding.button.setOnClickListener {
            questionControl(binding.button)
            pageControl(it)
        }
        binding.button7.setOnClickListener {
            questionControl(binding.button7)
            pageControl(it)
        }
        binding.button8.setOnClickListener {
            questionControl(binding.button8)
            pageControl(it)
        }
        binding.button6.setOnClickListener {
            questionControl(binding.button6)
            pageControl(it)
        }
    }

    fun pageControl(view: View){
        questionNu++

        if(questionNu != 5){
            getQuestion()
        }
        else{
            Navigation.findNavController(view).navigate(R.id.action_questionsFragment_to_resultFragment)
        }
    }

    private fun getQuestion(){
        binding.textView3.text = "${questionNu+1}. Question"
        correctAnswer = questions.get(questionNu)

        Log.e("INFO",correctAnswer.flag_url
        )

        binding.imageView.setImageResource(resources.getIdentifier(correctAnswer.flag_url,"drawable","com.yusuf.quizapp"))

        wrongAnswers = dao.get3Flag(correctAnswer.flag_id)

        options = HashSet()
        options.add(correctAnswer)
        options.add(wrongAnswers[0])
        options.add(wrongAnswers[1])
        options.add(wrongAnswers[2])

        binding.button.text = options.elementAt(0).flag_name
        binding.button6.text = options.elementAt(1).flag_name
        binding.button7.text = options.elementAt(2).flag_name
        binding.button8.text = options.elementAt(3).flag_name

    }

    fun questionControl(button: Button){

        val answer = button.text

        if (answer == correctAnswer.flag_name){
            correctQuestionNu++
        }
        else{
            inCorrectQuestionNu++
        }

        binding.textView.text = "Correct: $correctQuestionNu"
        binding.textView2.text = "Correct: $inCorrectQuestionNu"
    }

}