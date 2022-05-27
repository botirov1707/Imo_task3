package com.example.imo_task3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.kotlin.model.Chat

class ChatAdapter(private val chatList: List<Chat>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_FIRST_THIRD_VIEW = 0
    private val TYPE_SIMPLE_VIEW = 1
    private val TYPE_SPACE_VIEW = 2

    override fun getItemViewType(position: Int): Int {
        return if (position < 3) {
            TYPE_FIRST_THIRD_VIEW
        } else if (position == 3) {
            TYPE_SPACE_VIEW
        } else {
            TYPE_SIMPLE_VIEW
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_SIMPLE_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
            SimpleViewHolder(view)
        } else if (viewType == TYPE_SPACE_VIEW) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.space, parent, false)
            SpaceViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_1_3, parent, false)
            OneToThirdViewHolder(view)
        }
    }

    class SpaceViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class OneToThirdViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.item_first_img)
        val title = view.findViewById<TextView>(R.id.item_first_title)
    }

    class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.iv_profile)
        val isOnline = view.findViewById<TextView>(R.id.tv_count)
        val name = view.findViewById<TextView>(R.id.contact_name)
        val call = view.findViewById<ImageView>(R.id.call)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = chatList[position]

        if (holder is OneToThirdViewHolder) {
            holder.apply {
                when (position) {
                    0 -> {
                        image.setImageResource(R.drawable.add_user)
                        title.text = "New Contacts"
                    }
                    1 -> {
                        image.setImageResource(R.drawable.ic_baseline_call_24)
                        title.text = "Call History"
                    }
                    2 -> {
                        image.setImageResource(R.drawable.sms)
                        title.text = "New Group Chat"
                    }
                }
            }
        }
        if (holder is SpaceViewHolder) {

        }
        if (holder is SimpleViewHolder) {
            if (position == 4) {
                holder.apply {
                    image.setImageResource(R.drawable.following)
                    isOnline.visibility = View.GONE
                    name.text = "Follow"
                    call.setImageResource(R.drawable.ic_next)
                }
            } else {
                holder.apply {
                    image.setImageResource(chat.image)
                    isOnline.visibility = View.VISIBLE
                    if (chat.isOnline) {
                        isOnline.setBackgroundResource(R.drawable.shape_circle_green)
                    } else {
                        isOnline.setBackgroundResource(R.drawable.shape_circle_orange)
                    }
                    name.text = chat.fullName
                    call.setImageResource(R.drawable.ic_baseline_call_24)
                }
            }
        }
    }

    override fun getItemCount() = chatList.size
}