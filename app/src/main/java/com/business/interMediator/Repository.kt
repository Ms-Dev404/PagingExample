package com.business.test.interMediator

import com.business.test.network.ApiService


class Repository( val apiService: ApiService){



   suspend fun getUserDetails(id: String)=apiService.getUserDetails(id)


}