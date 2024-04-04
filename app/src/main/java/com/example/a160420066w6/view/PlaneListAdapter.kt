package com.example.a160420066w6.view

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420066w6.databinding.PlaneListItemBinding
import com.example.a160420066w6.model.Planes


class PlaneListAdapter(val planeList:ArrayList<Planes>): RecyclerView.Adapter<PlaneListAdapter.PlaneViewHolder>() {
    class PlaneViewHolder(var binding: PlaneListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return planeList.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaneViewHolder {
        val binding =PlaneListItemBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return PlaneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaneViewHolder, position: Int) {
        holder.binding.txtID.text=planeList[position].id
        holder.binding.txtName.text=planeList[position].name

        holder.binding.btnDetail.setOnClickListener(){
           // val action = PlaneListFragmentDirections.actionPlaneDetail()
           // Navigation.findNavController(it).navigate(action)
        }

    }
    fun updatePlaneList(newPlaneList: ArrayList<Planes>) {
        planeList.clear()
        planeList.addAll(newPlaneList)
        notifyDataSetChanged()
    }

}