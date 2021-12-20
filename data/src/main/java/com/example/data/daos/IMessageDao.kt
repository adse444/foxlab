package com.example.data.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.data.models.MessageDB

@Dao
interface IMessageDao {

    @Query("SELECT * FROM msg_table")
    fun getAllMessages(): LiveData<List<MessageDB>>

    @Insert
    suspend fun addMessage(model: MessageDB)

    @Delete
    suspend fun deleteMessage(model: MessageDB)

    @Update
    suspend fun updateMessage(model: MessageDB)
}