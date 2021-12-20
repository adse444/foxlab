package com.example.foxlab.extensions

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import java.io.ByteArrayOutputStream

fun ImageView.ToBitmap(): ByteArray{
    val bitmap = (this.drawable as BitmapDrawable).bitmap
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
    val image = stream.toByteArray()

    return image
}