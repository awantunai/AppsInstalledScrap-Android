package com.awantunai.appsintalledscrap.model

import android.location.Location
import com.google.gson.annotations.SerializedName

data class DeviceLocationRequest(
	@SerializedName("location") var location: Location? = null
)
