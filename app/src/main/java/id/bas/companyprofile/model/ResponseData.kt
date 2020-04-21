package id.bas.companyprofile.model

import com.google.gson.annotations.SerializedName

data class ResponseData(

	@field:SerializedName("kelamin")
	val kelamin: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("jabatan")
	val jabatan: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)