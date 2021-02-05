package com.example.perritosapk.Model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.perritosapk.pojo.BreedEntity
import com.example.perritosapk.pojo.ImagesBreed

@Dao
interface DogDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBreed(list: List<BreedEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImgbreed(list: List<ImagesBreed>)

    @Query("SELECT * FROM breed_table")
    fun getAllBreed() :LiveData<List<BreedEntity>>

    @Query("SELECT * FROM image_table")
    fun getAllImgBreed() :LiveData<List<ImagesBreed>>

}