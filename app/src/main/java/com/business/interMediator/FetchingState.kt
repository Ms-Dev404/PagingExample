package com.business.test.interMediator

import java.lang.Exception

sealed class FetchingState<out T>(){

  object Loading

  data class Success(var response: Any):FetchingState<Any>()

  data class Error(var exception: Exception):FetchingState<Exception>()



}
