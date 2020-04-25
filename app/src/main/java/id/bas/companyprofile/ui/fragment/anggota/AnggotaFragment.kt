package id.bas.companyprofile.ui.fragment.anggota

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import id.bas.companyprofile.R
import id.bas.companyprofile.model.ResponseData
import id.bas.news.ApiRetrofit
import kotlinx.android.synthetic.main.fragment_anggota.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 */
class AnggotaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anggota, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_anggota.layoutManager = GridLayoutManager(activity, 2)
        getData()

    }

    private fun getData() {
        progress_circular_anggota.visibility = View.VISIBLE
        ApiRetrofit.create().getData().enqueue(object : Callback<List<ResponseData>> {
            override fun onFailure(call: Call<List<ResponseData>>?, t: Throwable?) {
                progress_circular_anggota.visibility = View.GONE
                Toast.makeText(activity,"Gagal dapatkan data", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<ResponseData>>?,
                response: Response<List<ResponseData>>?
            ) {

                if (response?.isSuccessful!!){
                    progress_circular_anggota.visibility = View.GONE
                    //tampilkan data nya dibagian ini
                    val list = ArrayList<ResponseData>()
                    var dataPosisi = response.body().size
                    //perulangan untuk data
                    for (posisi in 0 until dataPosisi){
                        var dataLooping = response.body().get(posisi)
                        list.add(dataLooping)
                    }
                    var adapterAnggota =  AdapterAnggota(list)
                    rv_anggota.adapter = adapterAnggota


                } else{
                    progress_circular_anggota.visibility = View.GONE
                    Toast.makeText(activity,"Gagal dapatkan data", Toast.LENGTH_LONG).show()
                }


            }
        } )
    }

}
