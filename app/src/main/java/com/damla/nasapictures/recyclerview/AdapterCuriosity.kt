package com.damla.nasapictures.recyclerview

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.damla.nasapictures.R
import com.damla.nasapictures.api.model.Photo
import com.damla.nasapictures.util.dowloadFromURL
import com.damla.nasapictures.util.placeHolderProgressBar
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class AdapterCuriosity: PagingDataAdapter<Photo,AdapterCuriosity.ViewHolder>(PhotoDiffCallBack()) {


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            fun bind (data : Photo){
                val currentSrc : String = data?.img_src
                val currentShootDate = data?.earth_date
                val currentMachineName = data?.rover.name
                val currentCamera = data?.camera.name
                val currentMissionStatus = data?.rover.status
                val currentLaunchDate = data?.rover.launch_date
                val currentLandingDate = data?.rover.landing_date
                itemView.image.dowloadFromURL(currentSrc, placeHolderProgressBar(itemView.context))
                itemView.rootView.setOnClickListener {
                    val myDialog:Dialog
                    myDialog = Dialog(itemView.context)
                    myDialog.setContentView(R.layout.custom_pop_up)
                    var imageView: ImageView = myDialog.findViewById(R.id.imageViewPopUp)
                    var textShootDate : TextView = myDialog.findViewById(R.id.textViewShootDate)
                    var textMachineName : TextView = myDialog.findViewById(R.id.textViewMachineName)
                    var textCamera : TextView = myDialog.findViewById(R.id.textViewCamera)
                    var textMissionStatus : TextView = myDialog.findViewById(R.id.textViewMissionStatus)
                    var textLaunchDate : TextView  = myDialog.findViewById(R.id.textViewLaunchDate)
                    var textLandingDate: TextView = myDialog.findViewById(R.id.textViewLandingDate)
                    imageView.dowloadFromURL(currentSrc, placeHolderProgressBar(itemView.context))
                    textShootDate.text = currentShootDate
                    textMachineName.text = currentMachineName
                    textCamera.text = currentCamera
                    textMissionStatus.text = currentMissionStatus
                    textLaunchDate.text = currentLaunchDate
                    textLandingDate.text = currentLandingDate
                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.show()
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }

    }
    private class PhotoDiffCallBack : DiffUtil.ItemCallback<Photo>(){
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
           return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem

        }

    }

}