package com.example.a160420066w6.viewmodel

import android.app.Application
import android.media.Image.Plane
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel (application: Application): AndroidViewModel(application){
    val planeLD = MutableLiveData<ArrayList<Plane>>()
    val planeLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    fun refresh(){
        planeLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue( getApplication()  )
        val url = "http://localhost/data/planes.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {

                val sType = object : TypeToken<List<Plane>>() { }.type
                val result = Gson().fromJson<List<Plane>>(it, sType)
                planeLD.value = result as ArrayList<Plane>?
                loadingLD.value = false

                Log.d("showvoley", result.toString())


            },
            {
                Log.d("showvoley", it.toString())
                planeLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }




}