package com.business.test.networkResponse

import com.business.test.model.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 data class UserResponse(@SerializedName("data") @Expose var data:ArrayList<User>, @SerializedName("total") @Expose var total:Int, @SerializedName("page") @Expose var page:Int, @SerializedName("limit") @Expose var limit:Int  ) {
}