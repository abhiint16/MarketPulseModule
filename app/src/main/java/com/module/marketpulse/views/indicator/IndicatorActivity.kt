package com.module.marketpulse.views.indicator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ActivityHomeBinding
import com.module.marketpulse.databinding.ActivityIndicatorBinding
import com.module.marketpulse.views.ViewCons
import com.module.marketpulse.views.home.model.InnerVariableResponse
import com.module.marketpulse.views.variable.adapter.VariableRecyclerAdapter
import com.module.marketpulse.views.variable.viewmodel.VariableActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class IndicatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityIndicatorBinding

    lateinit var innerVariableResponse: InnerVariableResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initObserver()
        setUp()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_indicator)
    }

    private fun setUp() {
        innerVariableResponse = intent.getParcelableExtra(ViewCons.IntentCons.VALUEDATA)!!
        binding.item = innerVariableResponse
    }

    private fun initObserver() {

    }
}