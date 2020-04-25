package id.bas.companyprofile.ui.fragment.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.bas.companyprofile.R
import id.bas.companyprofile.ui.activity.detail.DetailActivity
import id.bas.companyprofile.ui.fragment.home.model.ModelInfo
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_info_company.view.*

class AdapterInfo (val list : ArrayList<ModelInfo>) : RecyclerView.Adapter<AdapterInfo.MyHolder>() {

    inner class MyHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterInfo.MyHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_info_company,parent,false)

        return MyHolder(view)
          }

    override fun getItemCount(): Int {
      return list.size
          }

    override fun onBindViewHolder(holder: AdapterInfo.MyHolder, position: Int) {

        holder.itemView.tv_judul_info.text = list[position].nameInfo
        Glide.with(holder.itemView.context)
            .load(list[position].imageInfo)
            .into(holder.itemView.img_info)
        holder.itemView.setOnClickListener {

            val intent = Intent (holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("JUDUL", list[position].nameInfo)
            intent.putExtra("IMAGE", list[position].imageInfo)
            intent.putExtra("DETAIL", list[position].detailInfo)
            holder.itemView.context.startActivity(intent)
        }


           }
}