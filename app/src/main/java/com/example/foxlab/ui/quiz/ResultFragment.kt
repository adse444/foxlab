package com.example.foxlab.ui.quiz

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.foxlab.R
import kotlinx.android.synthetic.main.fragment_question.view.*
import kotlinx.android.synthetic.main.fragment_quiz.view.*

class ResultFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_result, container, false)

        if (arguments != null) {
            view.textView22.text = requireArguments()["result"] as String
        }


        return view;
    }

}