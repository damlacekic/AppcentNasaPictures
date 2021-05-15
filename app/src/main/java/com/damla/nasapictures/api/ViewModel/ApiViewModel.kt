/*

package com.damla.nasapictures.api.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.damla.nasapictures.api.model.AllPhotos
import com.damla.nasapictures.api.model.Photo
import com.damla.nasapictures.api.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiViewModel(application: Application):AndroidViewModel(application) {
    private val repository by lazy { Repository() }
    var myResponse: MutableLiveData<AllPhotos> = MutableLiveData()

    fun getPhotos(name:String,page:Int){
        viewModelScope.launch {
            repository.getPhotos(name,page).enqueue(object : Callback<AllPhotos> {
                override fun onResponse(call: Call<AllPhotos>, response: Response<AllPhotos>) {
                    if(response.isSuccessful){
                        myResponse.value = response.body()
                       // println("asdasdas${response.body()}")
                    }

                }

                override fun onFailure(call: Call<AllPhotos>, t: Throwable) {

                }

            })
        }
    }
}
*/
