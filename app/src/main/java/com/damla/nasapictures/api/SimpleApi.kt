package com.damla.nasapictures.api

import com.damla.nasapictures.api.model.AllPhotos
import com.damla.nasapictures.api.model.Photo
import retrofit2.Call
import retrofit2.Response


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("mars-photos/api/v1/rovers/{name}/photos?sol=1000&api_key=TukSIbms13lxHiJLgzzXxbLjulL6AIzTCFVnzPFo")
    suspend fun getPhotos(@Path("name") name : String,
                  @Query("per_page")per_page:Int?,
                  @Query("page") page: Int):

            Response<AllPhotos>


    @GET("mars-photos/api/v1/rovers/{name}/photos?sol=1000&api_key=TukSIbms13lxHiJLgzzXxbLjulL6AIzTCFVnzPFo")
    suspend fun getFilterdFotos(@Path("name") name : String,
                                @Query("per_page")per_page:Int?,
                                @Query("page") page: Int, @Query("camera") camera:String):

            Response<AllPhotos>


}