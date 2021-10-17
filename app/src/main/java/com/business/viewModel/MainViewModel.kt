package com.business.test.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.business.test.interMediator.FetchingState
import com.business.test.interMediator.Repository
import com.business.test.interMediator.UserPager

import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException

class MainViewModel(private var repository: Repository):ViewModel() {
    val pagedUserList= Pager(PagingConfig(pageSize = 10)){

        UserPager(repository.apiService)
    }.flow.cachedIn(viewModelScope)








fun getDetails(id:String)= liveData(Dispatchers.IO){

    emit(FetchingState.Loading)
    try {

      val response=repository.getUserDetails(id)

      emit(FetchingState.Success(response))

    }catch (httpErr:HttpException){
        emit(FetchingState.Error(httpErr))

    }catch (e:Exception){
        emit(FetchingState.Error(e))

    }
}

}