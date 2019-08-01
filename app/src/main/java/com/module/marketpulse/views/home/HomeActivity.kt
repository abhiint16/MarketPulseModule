package com.module.marketpulse.views.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ActivityHomeBinding
import com.module.marketpulse.views.ViewCons
import com.module.marketpulse.views.criteria.CriteriaActivity
import com.module.marketpulse.views.home.adapter.HomeRecyclerAdapter
import com.module.marketpulse.views.home.model.BaseResponse
import com.module.marketpulse.views.home.viewmodel.HomeActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var homeActivityViewModel: HomeActivityViewModel

    lateinit var binding: ActivityHomeBinding

    lateinit var mainRecyclerAdapter: HomeRecyclerAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var dividerItemDecoration: DividerItemDecoration


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
        homeActivityViewModel = ViewModelProviders.of(this, factory).get(HomeActivityViewModel::class.java)
    }

    private fun initRecyclerView() {
        mainRecyclerAdapter = HomeRecyclerAdapter()
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.homeRecycler.setLayoutManager(linearLayoutManager)
        dividerItemDecoration =
            DividerItemDecoration(binding.homeRecycler.getContext(), linearLayoutManager.getOrientation())
        binding.homeRecycler.addItemDecoration(dividerItemDecoration)
        binding.homeRecycler.setAdapter(mainRecyclerAdapter)
        mainRecyclerAdapter.setViewModel(homeActivityViewModel)
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    private fun setUp() {
        homeActivityViewModel.getApiData()
    }

    private fun initObserver() {
        homeActivityViewModel.observeForLiveData().observe(this, Observer { response ->
            mainRecyclerAdapter.addData(response as ArrayList<BaseResponse>)
        })

        homeActivityViewModel.observeForItemClickLiveData().observe(this, Observer { baseData ->
            val intent = Intent(this@HomeActivity, CriteriaActivity::class.java)
            intent.putExtra(ViewCons.IntentCons.BASEDATA, baseData)
            startActivity(intent)
        })
    }
}