package com.shoppingapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoppingapp.databinding.UniCartBinding

class AdapterUniversity : RecyclerView.Adapter<AdapterUniversity.UniversityViewHolder>() {

    private val universityList  = arrayListOf<UniversityModel>()

    inner class UniversityViewHolder(val uniCartBinding: UniCartBinding) :
        RecyclerView.ViewHolder(uniCartBinding.root){
            fun bind(item: UniversityModel){

                uniCartBinding.university = item


            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {

     val layout = UniCartBinding.inflate(LayoutInflater.from(parent.context),parent, false)
     return UniversityViewHolder(layout)
    }


    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) = holder.bind(universityList.get(position))

    override fun getItemCount(): Int {
      return universityList.size
    }

     @SuppressLint("NotifyDataSetChanged")
     fun updateList(list : List<UniversityModel>){
         universityList.clear()
         universityList.addAll(list)
         notifyDataSetChanged()

     }

}