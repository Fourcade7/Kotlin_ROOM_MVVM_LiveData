package com.pr7.kotlinmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pr7.kotlinmvvm.model.MainRepository
import com.pr7.kotlinmvvm.model.room.User

class MainViewModel:ViewModel() {


    val repository=MainRepository()

    fun readfromroom():LiveData<List<User>>{
        return repository.readalldata()
    }




}