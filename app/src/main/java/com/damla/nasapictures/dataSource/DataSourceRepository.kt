package com.damla.nasapictures.dataSource

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.damla.nasapictures.api.model.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSourceRepository {

 /*   fun getPhotos(name : String): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false,pageSize = 25),
            pagingSourceFactory = {
                DataSource(name)
            }

        ).flow
    }*/


    fun getPhotosFilteredLiveData(name:String,camera:String):LiveData<PagingData<Photo>>{
        return Pager(
            config = PagingConfig(enablePlaceholders = false,pageSize = 25),
            pagingSourceFactory = {
                DataSourceFiltered(name,camera)

            },

            ).liveData
    }
    fun getPhotosLiveData(name : String):LiveData<PagingData<Photo>>{
        return Pager(
            config = PagingConfig(enablePlaceholders = false,pageSize = 25),
            pagingSourceFactory = {
                DataSource(name)

            },

        ).liveData
    }
}