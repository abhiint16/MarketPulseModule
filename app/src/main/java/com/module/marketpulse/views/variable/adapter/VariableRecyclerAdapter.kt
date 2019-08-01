package com.module.marketpulse.views.variable.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ItemCriteriaRecyclerBinding
import com.module.marketpulse.databinding.ItemHomeRecyclerBinding
import com.module.marketpulse.databinding.ItemVariableRecyclerBinding
import com.module.marketpulse.views.home.model.BaseResponse
import com.module.marketpulse.views.home.viewmodel.HomeActivityViewModel

class VariableRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var floatArray: FloatArray

    fun addData(floatArray: FloatArray) {
        this.floatArray = floatArray
        floatArray.sort()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemVariableRecyclerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_variable_recycler,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val floatValue = floatArray.get(position)
        (holder as ViewHolder).bind(floatValue)
    }

    override fun getItemCount(): Int {
        if (floatArray.size == 0)
            return 0
        else
            return floatArray.size
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var binding: ItemVariableRecyclerBinding

        constructor(itemView: ItemVariableRecyclerBinding) : super(itemView.getRoot()) {
            this.binding = itemView
        }

        fun bind(float: Float) {
            binding.item = float
        }
    }

}