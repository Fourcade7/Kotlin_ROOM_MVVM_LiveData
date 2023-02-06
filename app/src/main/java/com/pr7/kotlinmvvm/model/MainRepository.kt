package com.pr7.kotlinmvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pr7.kotlinmvvm.model.room.User
import com.pr7.kotlinmvvm.utils.Constants.userDao

class MainRepository {




    fun readalldata():LiveData<List<User>>{
        return userDao.getAllUsers()
    }

}