package com.module.marketpulse.views.criteria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ItemCriteriaRecyclerBinding
import com.module.marketpulse.views.home.model.CriteriaResponse

class CriteriaRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var criteriaResponseList = ArrayList<CriteriaResponse>()

    fun addData(criteriaResponseList: ArrayList<CriteriaResponse>) {
        this.criteriaResponseList = criteriaResponseList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemCriteriaRecyclerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_criteria_recycler,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val criteriaResponse = criteriaResponseList.get(position)
        (holder as ViewHolder).bind(criteriaResponse)
    }

    override fun getItemCount(): Int {
        if (criteriaResponseList.size == 0)
            return 0
        else
            return criteriaResponseList.size
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var binding: ItemCriteriaRecyclerBinding

        constructor(itemView: ItemCriteriaRecyclerBinding) : super(itemView.getRoot()) {
            this.binding = itemView
        }

        fun bind(criteriaResponse: CriteriaResponse) {
            binding.item = criteriaResponse
        }
    }

}