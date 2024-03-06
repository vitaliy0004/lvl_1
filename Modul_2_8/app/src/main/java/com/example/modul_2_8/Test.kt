package com.example.modul_2_8

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.navigation.fragment.findNavController
import com.example.modul_2_8.databinding.FragmentTestBinding
import com.example.quiz.quiz.QuizStorage


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Test : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentTestBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    @SuppressLint("NewApi", "SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTestBinding.inflate(inflater)
        val question = QuizStorage.getQuiz(QuizStorage.Locale.Ru)
        val list = mutableListOf<Int>(1,2,3)
            binding.button1.setOnClickListener {
            binding.textView.text = QuizStorage.answer(question,list)
            val bundle = Bundle().apply { putString("param1", binding.textView.text.toString()) }
            findNavController().navigate(R.id.action_test_to_finish22, bundle)
        }

        binding.radioText1.text = question.questions[0].question
        binding.radiobutton11.text = question.questions[0].feedback[0]
        binding.radiobutton12.text = question.questions[0].feedback[1]
        binding.radiobutton13.text = question.questions[0].feedback[2]
        binding.radiobutton14.text = question.questions[0].feedback[3]
        binding.radioText2.text = question.questions[1].question
        binding.radiobutton21.text = question.questions[1].feedback[0]
        binding.radiobutton22.text = question.questions[1].feedback[1]
        binding.radiobutton23.text = question.questions[1].feedback[2]
        binding.radiobutton24.text = question.questions[1].feedback[3]
        binding.radioText3.text = question.questions[2].question
        binding.radiobutton31.text = question.questions[2].feedback[0]
        binding.radiobutton32.text = question.questions[2].feedback[1]
        binding.radiobutton33.text = question.questions[2].feedback[2]
        binding.radiobutton34.text = question.questions[2].feedback[3]
        binding.radioText2.alpha = 0f
        binding.radioText1.alpha = 0f
        binding.radioText3.alpha = 0f
        binding.radioText1.animate().apply {
            duration = 3000
            alpha(1f)
        }.start()
        binding.radioText2.animate().apply {
            duration = 3000
            alpha(1f)
        }.start()
        binding.radioText3.animate().apply {
            duration = 3000
            alpha(1f)
        }.start()
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_test_to_welcome2)
        }
        return binding.root }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}