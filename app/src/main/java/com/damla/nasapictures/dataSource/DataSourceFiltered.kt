
package com.damla.nasapictures.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.damla.nasapictures.api.RetrofitInstance
import com.damla.nasapictures.api.model.Photo
import retrofit2.HttpException
import java.io.IOException

class DataSourceFiltered(name:String,camera:String):PagingSource<Int,Photo>() {

    var name : String
    var camera : String
    init{
        this.name = name
        this.camera = camera
    }
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> { return try {
            val page = params.key ?: 1
            val response = RetrofitInstance.api.getFilterdFotos(name,params.loadSize,page,camera)
            val responseData = mutableListOf<Photo>()
            val photos = response.body()?.photos ?: emptyList()
            responseData.addAll(photos)


            LoadResult.Page(
                data = photos,
                prevKey = if(page==1)null else page-1,
                nextKey = page.plus(1)


            )
        }catch(exeption: IOException){
            val error = IOException("Please check internet collection")
            LoadResult.Error(error)
        }catch (exception: HttpException){
            LoadResult.Error(exception)
        }

    }
}
