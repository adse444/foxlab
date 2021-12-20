package com.example.data.repositories

import com.example.data.DBProvider
import com.example.data.models.MessageDB

class MessageRepository {

    private val messageDao = DBProvider.instance.MessageDao()

    companion object {
        val instance = MessageRepository()
    }

    fun getAllMessages() = messageDao.getAllMessages()

    suspend fun addMessage(model: MessageDB) = messageDao.addMessage(model)

    suspend fun deleteMessage(model: MessageDB) = messageDao.deleteMessage(model)

    suspend fun updateMessage(model: MessageDB) = messageDao.updateMessage(model)
}