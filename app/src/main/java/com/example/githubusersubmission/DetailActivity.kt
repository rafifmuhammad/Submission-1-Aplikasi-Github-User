package com.example.githubusersubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_USER = "detail_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail User"

        val avatar: ImageView = findViewById(R.id.img_avatar)
        val name: TextView = findViewById(R.id.txt_name)
        val username: TextView = findViewById(R.id.txt_username)
        val follower: TextView = findViewById(R.id.txt_user_follower)
        val following: TextView = findViewById(R.id.txt_user_following)
        val company: TextView = findViewById(R.id.txt_company)
        val location: TextView = findViewById(R.id.txt_location)
        val repository: TextView = findViewById(R.id.txt_repository)

        val users = intent.getParcelableExtra<User>(DETAIL_USER) as User

        avatar.setImageResource(users.avatar)
        name.text = users.name
        username.text = users.username
        follower.text = users.followers
        following.text = users.following
        company.text = users.company
        location.text = users.location
        repository.text = users.repository
    }
}
