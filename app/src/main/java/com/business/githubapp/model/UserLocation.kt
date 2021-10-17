package com.business.test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserLocation(@SerializedName("street") @Expose var street:String ,
                   @SerializedName("city") @Expose var city:String ,
                   @SerializedName("state") @Expose var state:String ,
                   @SerializedName("country") @Expose var country:String ,
                   @SerializedName("timezone") @Expose var timezone:String)




