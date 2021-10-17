package com.business.test.interMediator

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.business.test.interMediator.Repository
import com.business.test.model.User
import com.business.test.network.ApiService

import retrofit2.HttpException

class UserPager(var apiService: ApiService):PagingSource<Int,Any>() {



    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Any> {

        return try {

            val currentPage=params.key?:0
            val response=apiService?.getUsersList(currentPage)
            val responseData= mutableListOf<User>()
            responseData.addAll(response!!.data)
            val prevKey=if(currentPage==0) null else currentPage-1
            LoadResult.Page(responseData,prevKey = prevKey,nextKey = currentPage.plus(1))

        }catch (e:HttpException){

            LoadResult.Error(e)
        }

    }
}