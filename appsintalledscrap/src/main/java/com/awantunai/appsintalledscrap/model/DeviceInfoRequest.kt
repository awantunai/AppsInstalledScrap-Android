package com.awantunai.appsintalledscrap.model

data class DeviceInfoRequest(
		val id: String? = null,
		val customerId: Int? = null,
		val deviceId: String? = null,
		val phoneManufacturer: String? = null,
		val phoneModel: String? = null,
		val phoneBrand: String? = null,
		val operatingSystem: String? = null
)
