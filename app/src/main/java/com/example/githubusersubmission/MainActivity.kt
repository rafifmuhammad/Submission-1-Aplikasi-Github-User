package com.example.githubusersubmission

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: userAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = userAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _->
            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()

            val userMoveDetail = User(
                users[position].avatar,
                users[position].name,
                users[position].username,
                users[position].followers,
                users[position].following,
                users[position].location,
                users[position].repository,
                users[position].company
            )

            val moveToDetail = Intent(this@MainActivity, DetailActivity::class.java)
            moveToDetail.putExtra(DetailActivity.DETAIL_USER, userMoveDetail)
            startActivity(moveToDetail)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataCompany = resources.getStringArray(R.array.company)
        dataRepository = resources.getStringArray(R.array.repository)
        dataLocation = resources.getStringArray(R.array.location)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataAvatar.getResourceId(position, -1),
                dataName[position],
                dataUsername[position],
                dataFollower[position],
                dataFollowing[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}
