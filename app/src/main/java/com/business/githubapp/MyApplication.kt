package com.business.githubapp

import android.app.Application
import com.business.githubapp.network.RetrofitClient
import com.business.test.interMediator.Repository
import com.business.test.network.ApiService

class MyApplication:Application() {
    var service: ApiService?=null


   companion object{

        var repository: Repository?=null
   }
    override fun onCreate() {
        super.onCreate()
        service=service?:RetrofitClient().retrofitInstance()?.create(ApiService::class.java)

        repository= repository?:service?.let { Repository(it) }

    }
}