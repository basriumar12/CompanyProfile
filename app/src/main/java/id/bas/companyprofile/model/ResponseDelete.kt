package id.bas.companyprofile.model

import com.google.gson.annotations.SerializedName

data class ResponseDelete(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("kode")
	val kode: Int? = null
)