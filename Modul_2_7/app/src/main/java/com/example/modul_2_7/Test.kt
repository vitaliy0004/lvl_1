package com.example.modul_2_7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.modul_2_7.databinding.FragmentTestBinding
import com.example.quiz.quiz.Question
import com.example.quiz.quiz.Quiz
import com.example.quiz.quiz.QuizStorage

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Test.newInstance] factory method to
 * create an instance of this fragment.
 */
class Test : Fragment() {
    // TODO: Rename and change types of parameters
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




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTestBinding.inflate(inflater)
        val vopros = QuizStorage.getQuiz(QuizStorage.Locale.Ru)
        val list = mutableListOf<Int>(1,2,3)
            binding.button1.setOnClickListener {
            binding.textView.text = QuizStorage.answer(vopros,list)
            val bundle = Bundle().apply { putString("param1", binding.textView.text.toString()) }
            findNavController().navigate(R.id.action_test_to_finish22, bundle)
            // отравка файла в следующий фрагмент
        }

        binding.radioText1.text = vopros.questions[0].question
        binding.radiobutton11.text =vopros.questions[0].feedback[0]
        binding.radiobutton12.text =vopros.questions[0].feedback[1]
        binding.radiobutton13.text =vopros.questions[0].feedback[2]
        binding.radiobutton14.text =vopros.questions[0].feedback[3]
        binding.radioText2.text = vopros.questions[1].question
        binding.radiobutton21.text =vopros.questions[1].feedback[0]
        binding.radiobutton22.text =vopros.questions[1].feedback[1]
        binding.radiobutton23.text =vopros.questions[1].feedback[2]
        binding.radiobutton24.text =vopros.questions[1].feedback[3]
        binding.radioText3.text = vopros.questions[2].question
        binding.radiobutton31.text =vopros.questions[2].feedback[0]
        binding.radiobutton32.text =vopros.questions[2].feedback[1]
        binding.radiobutton33.text =vopros.questions[2].feedback[2]
        binding.radiobutton34.text =vopros.questions[2].feedback[3]

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_test_to_welcome2)
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Test.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Test().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}