package com.example.trial1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class Adapter(data:ArrayList<Lesson>,var context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var data:List<Lesson>

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout: View = LayoutInflater.from(parent.context).inflate(R.layout.video_edit,parent,false)
                return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val videoItem: Lesson = data[position]

        holder.title.text = videoItem.title
        holder.desc.text = videoItem.desc
        holder.video.setVideoPath(videoItem.videoUrl)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(item:View) : RecyclerView.ViewHolder(item) {

        var title:TextView
        var desc:TextView
        var video:VideoView

        init {

            title = item.findViewById(R.id.video_name)
            desc = item.findViewById(R.id.video_desc)
            video = item.findViewById(R.id.lesson_video)

        }



    }

}