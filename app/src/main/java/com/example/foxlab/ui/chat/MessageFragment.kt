package com.example.foxlab.ui.chat

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.util.Base64
import android.view.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.data.models.MessageDB
import com.example.foxlab.R
import com.example.foxlab.extensions.ToBitmap
import kotlinx.android.synthetic.main.fragment_message.*
import kotlinx.android.synthetic.main.fragment_message.view.*

class MessageFragment: Fragment(){

    private lateinit var chatViewModel: ChatViewModel

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data

            ImageClipped.setImageURI(data!!.data)
            ImageClipped.visibility = View.VISIBLE
            ClipButton.visibility = View.INVISIBLE
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_message, container, false)

        chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)

        setHasOptionsMenu(true);

        view.message_TextInput.setOnClickListener{
            it.message_TextInput.setText("")
            it.message_TextInput.setTextColor(Color.WHITE)
        }

        view.filledTextFieldMessage.setOnClickListener{
            it.message_TextInput.setText("")
            it.message_TextInput.setTextColor(Color.WHITE)
        }


        view.ClipButton.setOnClickListener {


            val intent = Intent()
                .setType("image/*") // <- it doesn't work if I put it here (".xxx")
                .setAction(Intent.ACTION_GET_CONTENT)
            val chooser = Intent.createChooser(intent, "Select a file")
            resultLauncher.launch(chooser)
        }

        view.nameTextInput.addTextChangedListener {
            if(view.nameTextInput.text.toString() != "" && view.nameTextInput.text.toString() != " " && view.message_TextInput.text.toString() != "" && view.message_TextInput.text.toString() != " ") {
                view.SendButton.setBackgroundColor(Color.parseColor("#F1D147"))
                view.SendButton.isEnabled = true
            }
            else{
                view.SendButton.setBackgroundColor(Color.parseColor("#817000"))
                view.SendButton.isEnabled = false
            }
        }

        view.message_TextInput.addTextChangedListener {
            if(view.nameTextInput.text.toString() != "" && view.nameTextInput.text.toString() != " " && view.message_TextInput.text.toString() != "" && view.message_TextInput.text.toString() != " ") {
                view.SendButton.setBackgroundColor(Color.parseColor("#F1D147"))
                view.SendButton.isEnabled = true
            }
            else{
                view.SendButton.setBackgroundColor(Color.parseColor("#817000"))
                view.SendButton.isEnabled = false
            }
        }

        view.SendButton.setOnClickListener {
            insertToDatabase()
        }

        view.button2.setOnClickListener { findNavController().popBackStack() }
        return view
    }

    private fun insertToDatabase() {
        val author = nameTextInput.text.toString()
        val message = message_TextInput.text.toString()

        if(inputCheck(author, message)){
            var photo: ByteArray? = null

            if(ImageClipped.visibility == View.VISIBLE){
                photo = Base64.encode(ImageClipped.ToBitmap(), Base64.DEFAULT)
            }

            val message = MessageDB(text = message, sender = author, photo =  photo)
            chatViewModel.addMessageModel(message)
            findNavController().popBackStack()
        }
        else{
            Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(author: String, message: String):Boolean{
        return !(TextUtils.isEmpty(author) && TextUtils.isEmpty(message))
    }

}