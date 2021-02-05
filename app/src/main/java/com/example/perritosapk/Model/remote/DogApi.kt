package com.example.perritosapk.Model.remote

import com.example.perritosapk.WrapperImg
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {

    @GET("breed/list")
    suspend fun fetchBreedList() : Response<WrapperImg>
//@patch sirve para emtregar parametro de raza dog en este caso a la consulta
    @GET("breed/{breed}/images/")
    suspend fun fetchImagesByBreed(@Path ("breed") breed:String): Response<WrapperImg>
}