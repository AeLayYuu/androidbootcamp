package com.aelayyuu.something.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aelayyuu.something.api.ApiClient
import com.aelayyuu.something.model.getimage.GetImage
import com.aelayyuu.something.model.getpopular.GetPopular
import com.aelayyuu.something.model.getvideos.GetResult
import com.aelayyuu.something.model.getvideos.GetVideo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private var result : MutableLiveData<GetPopular> = MutableLiveData()
    private var details : MutableLiveData<GetResult> = MutableLiveData()

    fun getResult () : LiveData<GetPopular> = result
    fun getDetaild () : LiveData<GetResult> = details

}