package com.shoppingapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoppingapp.databinding.SpecialtyCartBinding

class AdapterFaculty : RecyclerView.Adapter<AdapterFaculty.FacultyViewHolder>() {

    private val facultyList = arrayListOf<FacultyModel>()
    var clickListener: ((item: FacultyModel) -> Unit)? = null
    fun onClickListener(listener: (item: FacultyModel) -> Unit) {
        clickListener = listener
    }

    inner class FacultyViewHolder(val binding: SpecialtyCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FacultyModel) {
            with(binding) {
                val eyani = if (item.eyani == true) "əyani" else "qiyabi"
                specName.text = "${item.facultyName}"
                descripBtn.text = "Dövlət sifarişli giriş balı:  ${item.dspoint}\n " +
                         "Ödənişli giriş balı:  ${item.nonDsPoint}\n" +
                         "İllik:  ${item.fee}\n" +
                         "Təhsil forması:  $eyani"
            }

            binding.root.setOnClickListener {
                clickListener?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val layout =
            SpecialtyCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacultyViewHolder(layout)

    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) =
        holder.bind(facultyList.get(position))


    override fun getItemCount(): Int {
        return facultyList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<FacultyModel>) {
        facultyList.clear()
        facultyList.addAll(list)
        notifyDataSetChanged()

    }
}