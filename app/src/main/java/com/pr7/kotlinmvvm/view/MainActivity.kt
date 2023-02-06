package com.pr7.kotlinmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.pr7.kotlinmvvm.databinding.ActivityMainBinding
import com.pr7.kotlinmvvm.model.room.AppDatabase
import com.pr7.kotlinmvvm.model.room.User
import com.pr7.kotlinmvvm.model.room.UserDao
import com.pr7.kotlinmvvm.utils.Constants.TABLE_NAME
import com.pr7.kotlinmvvm.utils.Constants.userDao
import com.pr7.kotlinmvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var userAdapter: UserAdapter

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel=ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)
        val db = Room.databaseBuilder(
               applicationContext,
               AppDatabase::class.java, "$TABLE_NAME"
           ).allowMainThreadQueries().build()
           userDao=db.userDao()


        binding.apply {
            button1.setOnClickListener {
                val user=User(0,edittext1.text.toString())
                userDao.insertUser(user)

            }
        }

        binding.recyclerview1.layoutManager=LinearLayoutManager(this@MainActivity)
        viewModel.readfromroom().observe(this@MainActivity,{
            binding.textview1.text= it.size.toString()
            userAdapter=UserAdapter(this@MainActivity, it as ArrayList<User>)
            binding.recyclerview1.adapter=userAdapter

        })












    }
}