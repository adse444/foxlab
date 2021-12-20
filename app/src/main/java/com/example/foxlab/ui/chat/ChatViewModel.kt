package com.example.foxlab.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.MessageDB
import com.example.data.repositories.MessageRepository
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    val messages: LiveData<List<MessageDB>>
    private val repository: MessageRepository

    init{
        repository = MessageRepository()
        messages = MessageRepository.instance.getAllMessages()
    }

    fun addMessageModel(model: MessageDB = MessageDB(sender = "Title 1", text = "Subtitle 1", photo = null)) {
        viewModelScope.launch {
            MessageRepository.instance.addMessage(model)
        }
    }
}