package com.business.githubapp.network


import com.business.test.network.Urls.BASE_URL

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var retrofit:Retrofit?=null

    fun retrofitInstance():Retrofit?{

        if(retrofit==null){

           retrofit=Retrofit.Builder().baseUrl(BASE_URL).client(setNetworkIClient()).addConverterFactory(GsonConverterFactory.create()).build()
        }
     return retrofit
    }

   private fun setNetworkIClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .callTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20,TimeUnit.SECONDS)
            .build()
    }
}