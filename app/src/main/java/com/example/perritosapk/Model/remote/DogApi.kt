package com.example.perritosapk.Model.remote

import com.example.perritosapk.WrapperBreed
import com.example.perritosapk.WrapperImg
import com.example.perritosapk.pojo.BreedEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET("breeds/list/")
    suspend fun fetchBreedList() : Response<WrapperBreed>
//@patch sirve para emtregar parametro de raza dog en este caso a la consulta
    @GET("breed/{breed}/images/")
    suspend fun fetchImagesByBreed(@Path ("breed") breed:String): Response<WrapperImg>
}