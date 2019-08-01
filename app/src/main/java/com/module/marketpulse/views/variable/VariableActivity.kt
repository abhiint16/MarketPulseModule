package com.module.marketpulse.views.variable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ActivityHomeBinding
import com.module.marketpulse.views.ViewCons
import com.module.marketpulse.views.home.model.InnerVariableResponse
import com.module.marketpulse.views.variable.adapter.VariableRecyclerAdapter
import com.module.marketpulse.views.variable.viewmodel.VariableActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class VariableActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var variableActivityViewModel: VariableActivityViewModel

    lateinit var binding: ActivityHomeBinding

    lateinit var variableRecyclerAdapter: VariableRecyclerAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    lateinit var innerVariableResponse: InnerVariableResponse


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        initBinding()
        initViewModel()
        initRecyclerView()
        initObserver()
        setUp()
    }

    private fun initViewModel() {
        variableActivityViewModel = ViewModelProviders.of(this, factory).get(VariableActivityViewModel::class.java)
    }

    private fun initRecyclerView() {
        variableRecyclerAdapter = VariableRecyclerAdapter()
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.homeRecycler.setLayoutManager(linearLayoutManager)
        binding.homeRecycler.setAdapter(variableRecyclerAdapter)
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    private fun setUp() {
        innerVariableResponse = intent.getParcelableExtra(ViewCons.IntentCons.VALUEDATA)!!
        innerVariableResponse.values?.let { variableRecyclerAdapter.addData(it) }
    }

    private fun initObserver() {
        //do nothing
    }
}