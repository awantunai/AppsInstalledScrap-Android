package com.awantunai.appsintalledscrap

import com.google.gson.annotations.SerializedName

data class ApplicationsItemRequest(
	@SerializedName("name") var name : String? = null,
	@SerializedName("packageName") var packageName : String? = null,
	@SerializedName("installedAt")var installedAt : String? = null
)
