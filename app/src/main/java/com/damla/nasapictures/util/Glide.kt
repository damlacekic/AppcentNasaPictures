package com.damla.nasapictures.util

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.damla.nasapictures.R

fun ImageView.dowloadFromURL(url:String?,placeholderprogressbar : CircularProgressDrawable){
    val options = RequestOptions.placeholderOf(placeholderprogressbar).error(R.mipmap.ic_launcher)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)


}

@SuppressLint("ResourceAsColor")
fun placeHolderProgressBar(context: Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f

       /*
        setColorSchemeColors(R.color.)*/
       // colorSchemeColors[0] = R.color.design_default_color_on_primary
        start()
    }
}