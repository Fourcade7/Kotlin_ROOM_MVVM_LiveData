package com.pr7.kotlinmvvm.model.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.pr7.kotlinmvvm.utils.Constants.TABLE_NAME

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllUsers(): LiveData<List<User>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)
    @Update
    fun updateUser(user: User)
    @Delete
    fun deleteUser(user: User)
    @Query("DELETE FROM $TABLE_NAME")
    fun deleteAllUsers()
    @Query("SELECT * FROM $TABLE_NAME WHERE id=:idd ")
    fun loadbyid(idd:Int):User
}