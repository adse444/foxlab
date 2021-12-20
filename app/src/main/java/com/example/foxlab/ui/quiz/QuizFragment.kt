package com.example.foxlab.ui.quiz

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foxlab.R
import kotlinx.android.synthetic.main.fragment_quiz.view.*

class QuizFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_quiz, container, false)

        view.StartButton.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_quiz_to_question);
        }

        return view;
    }
}