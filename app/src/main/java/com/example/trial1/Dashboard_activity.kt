package com.example.trial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_activity)

        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/trial1-c4461.appspot.com/o/100a%20Factory_preview.mp4?alt=media&token=82b1a157-8de8-4f23-87fd-bc1f6612494e"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/trial1-c4461.appspot.com/o/190312_28_StadioOlimpicoAndFans_Drone_002.mp4?alt=media&token=a8abe3bd-994d-4fd2-9791-a9b5d7acc204"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/trial1-c4461.appspot.com/o/blaugrana.mp4?alt=media&token=462a9b2a-368d-4ac4-b54d-f5b57d94b880"

        var items = ArrayList<Lesson>()
        items.add(Lesson("Football","learn to juggle",lesson1))
        items.add(Lesson("Football","learn to juggle",lesson2))
        items.add(Lesson("Football","learn to juggle",lesson3))

        val list: RecyclerView = findViewById<RecyclerView>(R.id.videos_list)

        val adapter = Adapter(items,applicationContext)

        list.layoutManager = GridLayoutManager(applicationContext,1)

        list.adapter = adapter












    }
}