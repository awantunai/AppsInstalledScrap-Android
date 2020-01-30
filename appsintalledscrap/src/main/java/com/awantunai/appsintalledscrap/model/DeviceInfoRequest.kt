package com.awantunai.appsintalledscrap.model

data class DeviceInfoRequest(
		var id: String? = null,
		var customerId: Int? = null,
		var deviceId: String? = null,
		var phoneManufacturer: String? = null,
		var phoneModel: String? = null,
		var phoneBrand: String? = null,
		var operatingSystem: String? = null
)
