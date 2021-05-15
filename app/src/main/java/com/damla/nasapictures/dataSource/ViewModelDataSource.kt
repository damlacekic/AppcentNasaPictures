package com.damla.nasapictures.dataSource

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.damla.nasapictures.api.model.Photo
import com.damla.nasapictures.dataSource.DataSourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class ViewModelDataSource (application: Application):AndroidViewModel(application) {
    private var currentResult: Flow<PagingData<Photo>> ?=null
    private val repository by lazy{
        DataSourceRepository()
    }

/*
    fun searchPhotos(name:String,camera:String): Flow<PagingData<Photo>>{
        val newResult:Flow<PagingData<Photo>> = repository.getPhotos(name).cachedIn(viewModelScope)
        currentResult = newResult
        return newResult
    }*/

    private var currentResultLiveData: LiveData<PagingData<Photo>>?=null

    fun searchPhotoLiveData(name: String): LiveData<PagingData<Photo>>{
        val newResultLiveData: LiveData<PagingData<Photo>> = repository.getPhotosLiveData(name).cachedIn(viewModelScope)
        currentResultLiveData = newResultLiveData
        return newResultLiveData
    }
    private var currentResultFilteredLiveData:LiveData<PagingData<Photo>> ?= null

    fun searchPhotoFilteredLiveData(name: String,camera: String): LiveData<PagingData<Photo>>{
        val newResultFilteredData : LiveData<PagingData<Photo>> = repository.getPhotosFilteredLiveData(name,camera).cachedIn(viewModelScope)
        currentResultFilteredLiveData = newResultFilteredData
        return  newResultFilteredData
    }

}