package com.module.marketpulse.views.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.module.marketpulse.R
import com.module.marketpulse.databinding.ActivityHomeBinding
import com.module.marketpulse.views.home.viewmodel.HomeActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var homeActivityViewModel: HomeActivityViewModel

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        initBinding()
        initViewModel()
        initObserver()
        setUp()
    }

    private fun initViewModel() {
        homeActivityViewModel = ViewModelProviders.of(this, factory).get(HomeActivityViewModel::class.java)
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

        })
    }
}