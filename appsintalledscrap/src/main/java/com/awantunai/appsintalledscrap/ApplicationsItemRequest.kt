package com.awantunai.appsintalledscrap

import com.google.gson.annotations.SerializedName

data class ApplicationsItemRequest(
	@SerializedName("name") var name : String? = null,
	@SerializedName("installedAt")var installedAt : String? = null
)
