package com.example.githubusersubmission

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class userAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var users = arrayListOf<User>()
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    override fun getItem(i: Int): Any {
        return users[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
       return users.size
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val imgAvatar: ImageView = view.findViewById(R.id.img_avatar)
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtUsername: TextView = view.findViewById(R.id.txt_username)
        private val txtFollower: TextView = view.findViewById(R.id.txt_user_follower)
        private val txtFollowing: TextView = view.findViewById(R.id.txt_user_following)

        internal fun bind(user: User) {
            imgAvatar.setImageResource(user.avatar)
            txtName.text = user.name
            txtUsername.text = user.username
            txtFollower.text = user.followers
            txtFollowing.text = user.following
        }
    }
}