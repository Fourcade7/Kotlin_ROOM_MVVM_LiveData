package com.pr7.kotlinmvvm.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pr7.kotlinmvvm.utils.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class User constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val uid:Int,
    @ColumnInfo(name = "name")
    val name:String,

)