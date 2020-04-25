package id.bas.companyprofile.ui.activity.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import id.bas.companyprofile.R
import id.bas.companyprofile.UserSession
import id.bas.companyprofile.model.ResponseData
import id.bas.companyprofile.ui.fragment.anggota.AdapterAnggota
import id.bas.news.ApiRetrofit
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.fragment_anggota.*
import kotlinx.android.synthetic.main.item_view_login.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title ="Admin Anggota"

        rv_anggota_admin.layoutManager = LinearLayoutManager(this)
        adminLogin()
        getData()



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.action_add ->{

               val intent = Intent(this, DetailAnggotaAdminActivity::class.java)
               intent.putExtra("NAMA","")
               intent.putExtra("KELAMIN","")
               intent.putExtra("STATUS","")
               intent.putExtra("JABATAN","")
               intent.putExtra("FLAG","ADD")
               intent.putExtra("ID","")

               startActivity(intent)
           }
           android.R.id.home ->{
               finish()
           }
           R.id.action_refresh ->{
               getData()
           }
       }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_admin, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun getData() {
        progress_circular_anggota_admin.visibility = View.VISIBLE
        ApiRetrofit.create().getData().enqueue(object : Callback<List<ResponseData>> {
            override fun onFailure(call: Call<List<ResponseData>>?, t: Throwable?) {
                progress_circular_anggota_admin.visibility = View.GONE
                Toast.makeText(this@AdminActivity,"Gagal dapatkan data", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<ResponseData>>?,
                response: Response<List<ResponseData>>?
            ) {

                if (response?.isSuccessful!!){
                    progress_circular_anggota_admin.visibility = View.GONE
                    //tampilkan data nya dibagian ini
                    val list = ArrayList<ResponseData>()
                    var dataPosisi = response.body().size
                    //perulangan untuk data
                    for (posisi in 0 until dataPosisi){
                        var dataLooping = response.body().get(posisi)
                        list.add(dataLooping)
                    }
                    var adapterAnggota =  AdapterAnggotaAdmin(list)
                    rv_anggota_admin.adapter = adapterAnggota
                    adapterAnggota.notifyDataSetChanged()


                } else{
                    progress_circular_anggota.visibility = View.GONE
                    Toast.makeText(this@AdminActivity,"Gagal dapatkan data", Toast.LENGTH_LONG).show()
                }


            }
        } )
    }

    private fun adminLogin() {

        val mDialogView = LayoutInflater.from(this)
            .inflate(R.layout.item_view_login, null)

        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
            .setTitle("Login Admin")

        val mAlerDialog = mBuilder.show()
        mAlerDialog.setCancelable(false)

        //onclcik button
        mDialogView.btn_login.setOnClickListener {
            //logic login
            var userName = mDialogView.edt_username.text.toString()
            var pass = mDialogView.edt_pass.text.toString()

            if(userName.isEmpty()){
                Toast.makeText(this,"Data tidak bisa kosong",
                    Toast.LENGTH_LONG).show()
            }
            else if(pass.isEmpty()){
                Toast.makeText(this,"Data tidak bisa kosong",
                    Toast.LENGTH_LONG).show()
            } else{
                if (userName.equals("admin") && pass.equals("1234567")){
                    Toast.makeText(this,"Berhasil Login",
                        Toast.LENGTH_LONG).show()
                    UserSession(this).makeSession("admin")
                    mAlerDialog.dismiss()
                } else{
                    Toast.makeText(this,"Gagal Login",
                        Toast.LENGTH_LONG).show()
                }

            }
        }

        mDialogView.btn_cancel.setOnClickListener {
            finish()
        }
        //validasi untuk cek kalo sudah login
        if (UserSession(this).hasSession()){
            mAlerDialog.dismiss()
        }



    }


}
