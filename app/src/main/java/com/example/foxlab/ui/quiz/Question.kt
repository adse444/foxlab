package com.example.foxlab.ui.quiz

import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foxlab.R
import com.example.foxlab.utils.QList
import com.example.foxlab.utils.Question
import kotlinx.android.synthetic.main.fragment_question.view.*
import androidx.navigation.fragment.findNavController


class Question: Fragment() {

    var ans = 0;
    var plus = true;
    val Questions: List<Question> = QList;
    var Pointer: Int = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_question, container, false)


        view.button9.isEnabled = false
        view.button9.setBackgroundColor(Color.parseColor("#817000"))
        view.questionNumber.text = "Вопрос 1/10"

        var Question: Question = Questions[Pointer]
        var QLen: Int = Questions.size

        view.question.text = Question.Question;

        view.answer1.text = Question.ans1
        view.answer2.text = Question.ans2
        view.answer3.text = Question.ans3
        view.answer4.text = Question.ans4



        view.button9.setOnClickListener {
            view.button9.setBackgroundColor(Color.parseColor("#817000"))
            view.choice1.visibility = View.INVISIBLE
            view.choice2.visibility = View.INVISIBLE
            view.choice3.visibility = View.INVISIBLE
            view.choice4.visibility = View.INVISIBLE

            view.container1.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container2.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container3.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container4.setBackgroundColor(Color.parseColor("#0DFFFFFF"))

            view.button9.isEnabled = false;

            plus = true;

            if(Pointer+1<QLen) {
                Pointer++;

                view.questionNumber.text = "Вопрос " + (Pointer+1) + "/" + QLen

                var Question: Question = Questions[Pointer]

                view.question.text = Question.Question;

                view.answer1.text = Question.ans1
                view.answer2.text = Question.ans2
                view.answer3.text = Question.ans3
                view.answer4.text = Question.ans4
            }
            else {
                plus = true;

                val bundle = Bundle()
                bundle.putString("result", getResources().getString(R.string.quiz_Result) + " " + ans +" вопросов из " + QLen + ". " +
                        getResources().getString(R.string.quiz_Result2))

                findNavController().navigate(R.id.action_question_to_resultFragment, bundle)
            }
        }

        view.container1.setOnClickListener {
            var AnsId: Int = 1;

            view.choice1.visibility = View.VISIBLE

            view.choice2.visibility = View.INVISIBLE
            view.choice3.visibility = View.INVISIBLE
            view.choice4.visibility = View.INVISIBLE

            view.container1.background = getResources().getDrawable(R.drawable.border)

            view.container2.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container3.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container4.setBackgroundColor(Color.parseColor("#0DFFFFFF"))

            if(AnsId == Questions[Pointer].rightAns && plus == true) {
                ans++
                plus = false
            }
            else if(plus == false){
                ans--
                plus = true
            }
            clickableButton(view)
        }

        view.container2.setOnClickListener {
            var AnsId: Int = 2;

            view.choice2.visibility = View.VISIBLE

            view.choice1.visibility = View.INVISIBLE
            view.choice3.visibility = View.INVISIBLE
            view.choice4.visibility = View.INVISIBLE

            view.container2.background = getResources().getDrawable(R.drawable.border)

            view.container1.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container3.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container4.setBackgroundColor(Color.parseColor("#0DFFFFFF"))

            if(AnsId == Questions[Pointer].rightAns && plus == true) {
                ans++
                plus = false
            }
            else if(plus == false){
                ans--
                plus = true
            }
            clickableButton(view)
        }

        view.container3.setOnClickListener {
            var AnsId: Int = 3;

            view.choice3.visibility = View.VISIBLE

            view.choice2.visibility = View.INVISIBLE
            view.choice1.visibility = View.INVISIBLE
            view.choice4.visibility = View.INVISIBLE

            view.container3.background = getResources().getDrawable(R.drawable.border)

            view.container2.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container1.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container4.setBackgroundColor(Color.parseColor("#0DFFFFFF"))

            if(AnsId == Questions[Pointer].rightAns && plus == true) {
                ans++
                plus = false
            }
            else if(plus == false){
                ans--
                plus = true
            }
            clickableButton(view)
        }

        view.container4.setOnClickListener {
            var AnsId: Int = 4;

            view.choice4.visibility = View.VISIBLE

            view.choice2.visibility = View.INVISIBLE
            view.choice3.visibility = View.INVISIBLE
            view.choice1.visibility = View.INVISIBLE

            view.container4.background = getResources().getDrawable(R.drawable.border)

            view.container2.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container3.setBackgroundColor(Color.parseColor("#0DFFFFFF"))
            view.container1.setBackgroundColor(Color.parseColor("#0DFFFFFF"))

            if(AnsId == Questions[Pointer].rightAns && plus == true) {
                ans++
                plus = false
            }
            else if(plus == false){
                ans--
                plus = true
            }
            clickableButton(view)
        }

        return view
    }

    private fun clickableButton(view: View)
    {
        view.button9.isEnabled = true;
        view.button9.setBackgroundColor(Color.parseColor("#F1D147"))
    }

}