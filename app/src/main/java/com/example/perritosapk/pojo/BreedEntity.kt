package com.example.perritosapk.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "breed_table")
data class BreedEntity(@PrimaryKey val breed :String )



