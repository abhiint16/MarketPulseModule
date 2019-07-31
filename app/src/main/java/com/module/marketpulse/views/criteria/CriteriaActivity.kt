package com.module.marketpulse.views.criteria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ActivityHomeBinding
import com.module.marketpulse.views.criteria.adapter.CriteriaRecyclerAdapter
import com.module.marketpulse.views.criteria.viewmodel.CriteriaViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class CriteriaActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var criteriaViewModel: CriteriaViewModel

    lateinit var binding: ActivityHomeBinding

    lateinit var criteriaRecyclerAdapter: CriteriaRecyclerAdapter
    lateinit var linearLayoutManager: LinearLayoutManager


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
        criteriaViewModel = ViewModelProviders.of(this, factory).get(CriteriaViewModel::class.java)
    }

    private fun initRecyclerView() {
        criteriaRecyclerAdapter = CriteriaRecyclerAdapter()
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.homeRecycler.setLayoutManager(linearLayoutManager)
        binding.homeRecycler.setAdapter(criteriaRecyclerAdapter)
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    private fun setUp() {

    }

    private fun initObserver() {
        criteriaViewModel.observeForLiveData().observe(this, Observer { response ->

        })
    }
}