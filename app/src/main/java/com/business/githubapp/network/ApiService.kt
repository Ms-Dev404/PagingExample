package com.business.test.network

import com.business.test.networkResponse.UserDetailsResponse
import com.business.test.networkResponse.UserResponse
import retrofit2.http.*

interface ApiService {


@Headers("app-id: ${Urls.APP_ID}")
@GET(Urls.GET_USERS)
 suspend fun getUsersList(@Query("page") page:Int):UserResponse

    @Headers("app-id: ${Urls.APP_ID}")
    @GET("${Urls.GET_USER_DETAILS}{id}")
    suspend fun getUserDetails(@Path("id") id: String): UserDetailsResponse


}