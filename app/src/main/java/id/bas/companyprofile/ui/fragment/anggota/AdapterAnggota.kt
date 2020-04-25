package id.bas.companyprofile.ui.fragment.anggota

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.bas.companyprofile.R
import id.bas.companyprofile.model.ResponseData
import id.bas.companyprofile.ui.activity.detail.DetailActivity
import id.bas.companyprofile.ui.activity.detail_anggota.DetailAnggotaActivity
import id.bas.companyprofile.ui.fragment.home.model.ModelInfo
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_anggota.view.*
import kotlinx.android.synthetic.main.item_info_company.view.*

class AdapterAnggota (val list : ArrayList<ResponseData>)
    : RecyclerView.Adapter<AdapterAnggota.MyHolder>() {

    inner class MyHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterAnggota.MyHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anggota,parent,false)

        return MyHolder(view)
          }

    override fun getItemCount(): Int {
      return list.size
          }

    override fun onBindViewHolder(holder: AdapterAnggota.MyHolder, position: Int) {

        holder.itemView.tv_nama_anggota.text = list[position].nama
        holder.itemView.tv_posisi_anggota.text = list[position].jabatan

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailAnggotaActivity::class.java)
            intent.putExtra("NAMA",list[position].nama)
            intent.putExtra("KELAMIN",list[position].kelamin)
            intent.putExtra("STATUS",list[position].status)
            intent.putExtra("JABATAN",list[position].jabatan)

            holder.itemView.context.startActivity(intent)
        }



           }


}