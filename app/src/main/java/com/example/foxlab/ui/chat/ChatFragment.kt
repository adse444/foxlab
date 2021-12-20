package com.example.foxlab.ui.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foxlab.MainActivity
import com.example.foxlab.R
import com.example.foxlab.databinding.FragmentChatBinding
import kotlinx.android.synthetic.main.fragment_chat.view.*

class ChatFragment : Fragment() {

    private val Adapter by lazy{
        MessageAdapter()
    }

    private lateinit var chatViewModel: ChatViewModel
    private var _binding: FragmentChatBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        chatViewModel =ViewModelProvider(this).get(ChatViewModel::class.java)

        _binding = FragmentChatBinding.inflate(inflater, container, false)
        val root: View = binding.root

       root.button1.setOnClickListener { findNavController().navigate(R.id.action_chatFragment_to_MessageFragment) }


        setHasOptionsMenu(true);

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        setUpViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpViewModel() {
        chatViewModel.messages.observe(viewLifecycleOwner) {
            Adapter.set(it)
        }

    }

    private fun setUpUI() {
        binding.recyclerView.apply {
            layoutManager= LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = Adapter
        }
    }
}