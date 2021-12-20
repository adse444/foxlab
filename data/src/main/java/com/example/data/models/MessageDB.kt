package com.example.data.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "msg_table")
data class MessageDB(
    @PrimaryKey var uuid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "msg_sender") var sender: String,
    @ColumnInfo(name = "msg_text") var text: String,
    @ColumnInfo(name = "msg_photo", typeAffinity = ColumnInfo.BLOB) var photo: ByteArray?,
): Serializable