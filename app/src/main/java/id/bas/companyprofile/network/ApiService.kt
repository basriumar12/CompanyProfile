package id.bas.news

import id.bas.companyprofile.model.ResponseData
import id.bas.companyprofile.model.ResponseDelete
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("get_company.php")
    fun getData () : Call<List<ResponseData>>

    @FormUrlEncoded
    @POST("edit_company.php")
    fun edit (
        @Field("nama") nama : String,
        @Field("id") id : String,
        @Field("kelamin") kelamin : String,
        @Field("status") status : String,
        @Field("jabatan") jabatan : String

              ) : Call<ResponseDelete>

    @FormUrlEncoded
    @POST("edit_company.php")
    fun delete (
        @Field("id") id : String
              ) : Call<ResponseDelete>

    @FormUrlEncoded
    @POST("insert_company.php")
    fun insert (
        @Field("nama") nama : String,
        @Field("kelamin") kelamin : String,
        @Field("status") status : String,
        @Field("jabatan") jabatan : String

              ) : Call<ResponseDelete>


}