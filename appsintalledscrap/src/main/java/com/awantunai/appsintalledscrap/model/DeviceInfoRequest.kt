package com.awantunai.appsintalledscrap.model

import com.google.gson.annotations.SerializedName

data class DeviceInfoRequest(
	@SerializedName("id") var id: String? = null,
	@SerializedName("customerId") var customerId: Int? = null,
	@SerializedName("deviceId") var deviceId: String? = null,
	@SerializedName("phoneManufacturer") var phoneManufacturer: String? = null,
	@SerializedName("phoneModel") var phoneModel: String? = null,
	@SerializedName("phoneBrand") var phoneBrand: String? = null,
	@SerializedName("operatingSystem") var operatingSystem: String? = null
)
