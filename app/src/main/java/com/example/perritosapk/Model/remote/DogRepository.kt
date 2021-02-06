package com.example.perritosapk.Model.remote

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.perritosapk.Model.local.DogDao
import com.example.perritosapk.pojo.BreedEntity

class DogRepository (private val dao: DogDao) {

 private val services = RetrofitDog.retrofitInstance()
 val liveDataDogBreedInDB = dao.getAllBreed()
 val liveDataDogImgInDb = dao.getAllImgBreed()
 // Función que utiliza las coroutina para la conexión al servicio.

 suspend fun getDogCoroutines() {
  Log.d("REPOSITORY", "UTILIZANDO COROUTINES")
  try {
   val response = RetrofitDog.retrofitInstance().fetchBreedList()


   when (response.isSuccessful) {
    true -> response.body()?.let {
     Log.d("BreedList", "${it.breed}")
     //Aca se esta insertando en la Base de datos
    dao.insertAllBreed(converted(it.breed))
    }
    false -> Log.d("ERROR", " ${response.code()} : ${response.errorBody()} ")
   }
  } catch (t: Throwable) {
   Log.e("ERROR CORUTINA", t.message.toString())
  }
 }

 fun converted(list: List<String>): List<BreedEntity> {
  var listBreed = mutableListOf<BreedEntity>()
  list.map {
   listBreed.add(BreedEntity(it))
  }
  return listBreed
 }
}