package id.bas.companyprofile.ui.activity.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import id.bas.companyprofile.R
import id.bas.companyprofile.model.ResponseDelete
import id.bas.news.ApiRetrofit
import kotlinx.android.synthetic.main.activity_detail_anggota_admin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailAnggotaAdminActivity : AppCompatActivity() {

    var nama = ""
    var kelamin =""
    var status =""
    var jabatan = ""
    var flag =""
    var id = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anggota_admin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title ="Detail Admin Anggota"


        nama = intent.getStringExtra("NAMA")
        kelamin = intent.getStringExtra("KELAMIN")
        status = intent.getStringExtra("STATUS")
        jabatan = intent.getStringExtra("JABATAN")
        flag = intent.getStringExtra("FLAG")
        id = intent.getStringExtra("ID")

        if (flag.equals("ADD")){
            btn_simpan_anggota.visibility = View.VISIBLE
        }

        if (flag.equals("EDIT")){
            btn_edit_anggota.visibility = View.VISIBLE
            btn_hapus_anggota.visibility = View.VISIBLE

            edt_nama_anggota.setText(nama)
            edt_jabatan_anggota.setText(jabatan)
            edt_kelamin_anggota.setText(kelamin)
            edt_status_anggota.setText(status)
        }



        btn_hapus_anggota.setOnClickListener {
            deleteData()
        }

        btn_edit_anggota.setOnClickListener {
            editData()
        }

        btn_simpan_anggota.setOnClickListener {
            addData()
        }


    }

    private fun deleteData() {
        ApiRetrofit.create().delete(id)
            .enqueue(object : Callback<ResponseDelete>{
                override fun onFailure(call: Call<ResponseDelete>?, t: Throwable?) {
                    Toast.makeText(this@DetailAnggotaAdminActivity,"Gagal Hapus", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<ResponseDelete>?,
                    response: Response<ResponseDelete>?
                ) {

                    if (response != null)
                    {
                        if (response.isSuccessful){
                            Toast.makeText(this@DetailAnggotaAdminActivity,"Berhasil Hapus", Toast.LENGTH_LONG).show()
                            finish()

                        }
                    } else{
                        Toast.makeText(this@DetailAnggotaAdminActivity,"Gagal Hapus", Toast.LENGTH_LONG).show()
                    }

                }
            })

    }

    private fun addData() {
        if (edt_nama_anggota.text.toString().isEmpty() ){
            edt_nama_anggota.setError("Data tidak bisa kosong")
        }
        else if (edt_kelamin_anggota.text.toString().isEmpty() ){
            edt_kelamin_anggota.setError("Data tidak bisa kosong")
        }
        else if (edt_jabatan_anggota.text.toString().isEmpty() ){
            edt_jabatan_anggota.setError("Data tidak bisa kosong")
        }
        else if (edt_status_anggota.text.toString().isEmpty() ){
            edt_status_anggota.setError("Data tidak bisa kosong")
        } else {
            val nama = edt_nama_anggota.text.toString()
            val kelamin = edt_kelamin_anggota.text.toString()
            val status = edt_status_anggota.text.toString()
            val jabatan = edt_jabatan_anggota.text.toString()
            ApiRetrofit.create().insert(nama, kelamin, status, jabatan)
                .enqueue(object : Callback<ResponseDelete> {
                    override fun onFailure(call: Call<ResponseDelete>?, t: Throwable?) {
                        Toast.makeText(
                            this@DetailAnggotaAdminActivity,
                            "Gagal Tambah Data",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseDelete>?,
                        response: Response<ResponseDelete>?
                    ) {

                        if (response != null) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@DetailAnggotaAdminActivity,
                                    "Berhasil Tambah Data",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }
                        } else {
                            Toast.makeText(
                                this@DetailAnggotaAdminActivity,
                                "Gagal Tambah Data",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                })

        }
    }

    private fun editData() {
        if (edt_nama_anggota.text.toString().isEmpty() ){
            edt_nama_anggota.setError("Data tidak bisa kosong")
        }
        else if (edt_kelamin_anggota.text.toString().isEmpty() ){
            edt_kelamin_anggota.setError("Data tidak bisa kosong")
        }
        else if (edt_jabatan_anggota.text.toString().isEmpty() ){
            edt_jabatan_anggota.setError("Data tidak bisa kosong")
        }
        else if (edt_status_anggota.text.toString().isEmpty() ){
            edt_status_anggota.setError("Data tidak bisa kosong")
        } else {
            val nama = edt_nama_anggota.text.toString()
            val kelamin = edt_kelamin_anggota.text.toString()
            val status = edt_status_anggota.text.toString()
            val jabatan = edt_jabatan_anggota.text.toString()
            ApiRetrofit.create().edit(nama, id, kelamin, status, jabatan)
                .enqueue(object : Callback<ResponseDelete> {
                    override fun onFailure(call: Call<ResponseDelete>?, t: Throwable?) {
                        Toast.makeText(
                            this@DetailAnggotaAdminActivity,
                            "Gagal Edit",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onResponse(
                        call: Call<ResponseDelete>?,
                        response: Response<ResponseDelete>?
                    ) {

                        if (response != null) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@DetailAnggotaAdminActivity,
                                    "Berhasil Edit",
                                    Toast.LENGTH_LONG
                                ).show()
                                finish()
                            }
                        } else {
                            Toast.makeText(
                                this@DetailAnggotaAdminActivity,
                                "Gagal Edit",
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }
                })

        }

    }
}
