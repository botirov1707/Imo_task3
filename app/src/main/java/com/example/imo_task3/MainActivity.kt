package com.example.imo_task3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.kotlin.model.Chat

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.rv_main)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: java.util.ArrayList<Chat>) {
        val adapter = ChatAdapter(chats)
        recyclerView.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Chat> {
        val chats: ArrayList<Chat> = ArrayList()
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))
        chats.add(Chat(R.drawable.user, "Botirov Bekhruzbek", true))

        return chats
    }
}