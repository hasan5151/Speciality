package com.shoppingapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoppingapp.databinding.AllUniCartBinding

class AdapterUniversity : RecyclerView.Adapter<AdapterUniversity.AllUniversityViewHolder>() {

    private val allUniList = arrayListOf<UniversityModel>()
    var clickListener: ((item: UniversityModel) -> Unit)? = null

    fun onClickListener(listener: (item: UniversityModel) -> Unit) {
        clickListener = listener
    }

    inner class AllUniversityViewHolder(val allUniCartBinding : AllUniCartBinding) :
        RecyclerView.ViewHolder(allUniCartBinding.root) {

        fun bind(item : UniversityModel) {
            allUniCartBinding.allUniversity = item
            allUniCartBinding.root.setOnClickListener {
                clickListener?.invoke(item)
            }
        }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllUniversityViewHolder {
        val layout = AllUniCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllUniversityViewHolder(layout)
    }


    override fun onBindViewHolder(holder: AllUniversityViewHolder, position: Int) =
        holder.bind(allUniList.get(position))


    override fun getItemCount(): Int {
        return allUniList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<UniversityModel>){
        allUniList.clear()
        allUniList.addAll(list)
        notifyDataSetChanged()

    }
    }