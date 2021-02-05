package com.example.perritosapk.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_table")
data class ImagesBreed(@PrimaryKey
                       val imgURL :String,
                       val breed :String)
