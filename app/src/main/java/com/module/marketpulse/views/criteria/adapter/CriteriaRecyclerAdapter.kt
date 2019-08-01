package com.module.marketpulse.views.criteria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ItemCriteriaRecyclerBinding
import com.module.marketpulse.views.criteria.TypeValues
import com.module.marketpulse.views.home.model.CriteriaResponse
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.content.Intent
import android.graphics.Color
import android.text.method.LinkMovementMethod
import androidx.core.content.ContextCompat.startActivity
import android.view.View
import android.text.style.ClickableSpan
import android.widget.Toast
import com.module.marketpulse.views.ViewCons
import com.module.marketpulse.views.indicator.IndicatorActivity
import com.module.marketpulse.views.variable.VariableActivity


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
        criteriaResponse.finalString = criteriaResponse.text.toString()

        var startList: MutableList<Int> = ArrayList()
        var endList: MutableList<Int> = ArrayList()
        var clickableSpanList: MutableList<ClickableSpan> = ArrayList()

        if (TypeValues.TypeVariableString.PLAINTEXT.equals(criteriaResponse.type)) {
            val spannableString = SpannableString(criteriaResponse.finalString)
            criteriaResponse.finalSpannableString = spannableString
            (holder as ViewHolder).bind(criteriaResponse)
        } else {

            for (item in criteriaResponse.variable) {

                if (criteriaResponse.finalString!!.contains(item.key)) {
                    if (TypeValues.TypeValueString.VALUE.equals(item.value.type)) {

                        startList.add(criteriaResponse.finalString!!.indexOf(item.key))
                        val count = item.value.values!![0].toString().length
                        endList.add(criteriaResponse.finalString!!.indexOf(item.key) + count)

                        criteriaResponse.finalString =
                            criteriaResponse.finalString.replace(item.key, item.value.values!![0].toString(), true)
                    } else {

                        startList.add(criteriaResponse.finalString!!.indexOf(item.key))
                        val count = item.value.default_value.toString().length
                        endList.add(criteriaResponse.finalString!!.indexOf(item.key) + count)

                        criteriaResponse.finalString =
                            criteriaResponse.finalString.replace(item.key, item.value.default_value.toString(), true)
                    }
                }

                val clickableSpan = object : ClickableSpan() {
                    override fun onClick(textView: View) {
                        if (TypeValues.TypeValueString.VALUE.equals(item.value.type)) {
                            var intent = Intent(holder.itemView.context, VariableActivity::class.java)
                            intent.putExtra(ViewCons.IntentCons.VALUEDATA, item.value)
                            holder.itemView.context.startActivity(intent)
                        } else {
                            var intent = Intent(holder.itemView.context, IndicatorActivity::class.java)
                            intent.putExtra(ViewCons.IntentCons.VALUEDATA, item.value)
                            holder.itemView.context.startActivity(intent)
                        }
                    }

                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        ds.isUnderlineText = true
                    }
                }
                clickableSpanList.add(clickableSpan)
            }
            val spannableString = SpannableString(criteriaResponse.finalString)
            for ((index, item) in startList.withIndex()) {
                spannableString.setSpan(
                    clickableSpanList[index],
                    startList[index],
                    endList[index],
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                criteriaResponse.finalSpannableString = spannableString
            }
            (holder as ViewHolder).bind(criteriaResponse)
        }

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
            binding.text.setMovementMethod(LinkMovementMethod.getInstance());
            binding.text.setHighlightColor(Color.BLUE);

        }
    }

}