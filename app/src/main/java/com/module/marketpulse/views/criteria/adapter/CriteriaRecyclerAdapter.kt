package com.module.marketpulse.views.criteria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ItemHomeRecyclerBinding
import com.module.marketpulse.views.home.model.BaseResponse

class CriteriaRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var baseResponseList = ArrayList<BaseResponse>()

    fun addData(baseResponseList: ArrayList<BaseResponse>) {
        this.baseResponseList = baseResponseList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemHomeRecyclerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_home_recycler,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val baseResponse = baseResponseList.get(position)
        (holder as ViewHolder).bind(baseResponse)
    }

    override fun getItemCount(): Int {
        if (baseResponseList.size == 0)
            return 0
        else
            return baseResponseList.size
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var binding: ItemHomeRecyclerBinding

        constructor(itemView: ItemHomeRecyclerBinding) : super(itemView.getRoot()) {
            this.binding = itemView
        }

        fun bind(baseResponse: BaseResponse) {
            binding.item = baseResponse
        }
    }

}