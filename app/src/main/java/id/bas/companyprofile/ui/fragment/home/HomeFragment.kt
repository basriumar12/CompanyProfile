package id.bas.companyprofile.ui.fragment.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import id.bas.companyprofile.R
import id.bas.companyprofile.ui.activity.admin.AdminActivity
import id.bas.companyprofile.ui.activity.youtube.YotubeActivity
import id.bas.companyprofile.ui.fragment.home.model.ModelInfo
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_sosmed.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    var list = ArrayList<ModelInfo>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_home.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        list.addAll(DataInfo.listData)
        var adapter = AdapterInfo(list)
        rv_home.adapter = adapter
        adapter.notifyDataSetChanged()

        getDataYoutube()


        img_setting.setOnClickListener {
            startActivity(Intent(activity, AdminActivity::class.java))
        }


        card_fb.setOnClickListener {
            gotoSosmed("https://id-id.facebook.com/people/Basri/100034627880595")
        }
        card_ig.setOnClickListener {
            gotoSosmed("https://id-id.facebook.com/people/Basri/100034627880595")
        }

        card_twitt.setOnClickListener {
            gotoSosmed("https://id-id.facebook.com/people/Basri/100034627880595")
        }


    }

    fun gotoSosmed(url : String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }



    private fun getDataYoutube() {
        ytb.setOnClickListener {
            startActivity(Intent(activity, YotubeActivity::class.java))
        }
    }

}
