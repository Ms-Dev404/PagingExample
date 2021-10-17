package com.business.test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(@SerializedName("id") @Expose var id:String, @SerializedName("title") @Expose var title:String, @SerializedName("firstName") @Expose var firstName:String, @SerializedName("lastName") @Expose var lastName:String, @SerializedName("picture") @Expose var picture:String) {
}