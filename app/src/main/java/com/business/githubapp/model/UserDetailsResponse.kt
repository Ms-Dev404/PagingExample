package com.business.test.networkResponse

import com.business.test.model.UserLocation
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserDetailsResponse(@SerializedName("id") @Expose var id:String,
                               @SerializedName("title") @Expose var title:String,
                               @SerializedName("firstName") @Expose var firstName:String,
                               @SerializedName("lastName") @Expose var lastName:String,
                               @SerializedName("picture") @Expose var picture:String,
                               @SerializedName("gender") @Expose var gender:String ,
                               @SerializedName("email") @Expose var email:String ,
                               @SerializedName("dateOfBirth") @Expose var dateOfBirth:String ,
                               @SerializedName("phone") @Expose var phone:String,
                               @SerializedName("registerDate") @Expose var registerDate:String,
                               @SerializedName("updatedDate") @Expose var updatedDate:String , @SerializedName("location") @Expose var location: UserLocation
)