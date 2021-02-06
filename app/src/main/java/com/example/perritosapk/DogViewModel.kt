package com.example.perritosapk

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.perritosapk.Model.local.DogDataBase
import com.example.perritosapk.Model.remote.DogRepository
import com.example.perritosapk.pojo.BreedEntity
import kotlinx.coroutines.launch

class DogViewModel(application: Application) : AndroidViewModel(application){

    private val repository : DogRepository
    val allDogBreed : LiveData<List<BreedEntity>>
    init {
        Log.d("Init","inicio ViewModel")

        val dogDao = DogDataBase.getDataBase(application).getDogDao()
        repository = DogRepository(dogDao)
        viewModelScope.launch {
            repository.getDogCoroutines()
        }

        allDogBreed = repository.liveDataDogBreedInDB
    }
    private var selectedBreed : MutableLiveData<BreedEntity> = MutableLiveData()
    //metodo recibe objeto de tipo Breed
    fun selectedDog(breed: BreedEntity){
        selectedBreed.value= breed
    }
}