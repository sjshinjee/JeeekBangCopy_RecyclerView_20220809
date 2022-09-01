package com.example.jeeekbangcopy_recyclerview_20220809.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jeeekbangcopy_recyclerview_20220809.R
import com.example.jeeekbangcopy_recyclerview_20220809.datas.RoomData

class RoomRecyclerViewAdapter(
    val mContext: Context,
    val mList: List<RoomData>
) : RecyclerView.Adapter<RoomRecyclerViewAdapter.MyViewHolder>() {

    //내부클래스를 하나 만들어서 androidx에서 주는 ViewHolder를 상속받음 coz 원래<>내부에 VH들어갈것이므로
    /// 하나의 ViewHolder를 커스터마이징해서 만들어주는 거임
    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(item : RoomData) {
//            itemView - item  //실제로 리싸이클러뷰 뷰홀더에서 제공하는 한 칸의 뷰인 itemView에
                              /// 우리가 넣을 item(한 칸에 들어갈 RoomData)를 연결(bind)하는 거다
            val priceTxt = itemView.findViewById<TextView>(R.id.priceTxt)
            val addressTxt = itemView.findViewById<TextView>(R.id.addressTxt)
            val levelTxt = itemView.findViewById<TextView>(R.id.levelTxt)
            val descriptionTxt = itemView.findViewById<TextView>(R.id.descriptionTxt)

            priceTxt.text = item.getFormattedPrice()
            addressTxt.text = "${item.address}, "
            levelTxt.text = item.getFormattedLevel()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row = LayoutInflater.from(mContext).inflate(R.layout.room_list_item, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }


}