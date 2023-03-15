package com.shoppingapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoppingapp.databinding.UniCartBinding

class AdapterMeslek : RecyclerView.Adapter<AdapterMeslek.MeslekViewHolder>() {

    private val meslekList  = arrayListOf<MeslekModel>()
    var clickListener :((item : MeslekModel)->Unit)? = null
    fun onClickListener(listener :  (item : MeslekModel)->Unit){
        clickListener = listener
    }


    inner class MeslekViewHolder(val uniCartBinding: UniCartBinding) :
        RecyclerView.ViewHolder(uniCartBinding.root){
            fun bind(item: MeslekModel){
                uniCartBinding.meslek = item
                uniCartBinding.root.setOnClickListener {
                    clickListener?.invoke(item)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeslekViewHolder {

     val layout = UniCartBinding.inflate(LayoutInflater.from(parent.context),parent, false)
     return MeslekViewHolder(layout)
    }


    override fun onBindViewHolder(holder: MeslekViewHolder, position: Int) = holder.bind(meslekList.get(position))

    override fun getItemCount(): Int {
      return meslekList.size
    }

     @SuppressLint("NotifyDataSetChanged")
     fun updateList(list : List<MeslekModel>){
         meslekList.clear()
         meslekList.addAll(list)
         notifyDataSetChanged()

     }

}