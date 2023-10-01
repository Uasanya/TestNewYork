package com.example.testnewyork.ui.util

import android.widget.ImageView
import com.bumptech.glide.Glide

object GlideProvider {

    fun ImageView.setImage(url:String){
        Glide.with(context)
            .load(url)
            .into(this)
    }
}