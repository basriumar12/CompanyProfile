package id.bas.companyprofile.ui.activity.detail_anggota

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.bas.companyprofile.R
import kotlinx.android.synthetic.main.activity_detail_anggota.*

class DetailAnggotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anggota)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title ="Detail Anggota"

        tv_nama_anggota_detail.text = "Nama : "+intent.getStringExtra("NAMA")
        tv_kelamin_anggota_detail.text = "Kelamin : "+intent.getStringExtra("KELAMIN")
        tv_posisi_anggota_detail.text = "Jabatan : "+intent.getStringExtra("JABATAN")
        tv_status_anggota_detail.text = "Status : "+intent.getStringExtra("STATUS")
    }
}
