package com.example.app.feature.location.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.FragmentLocationBinding
import com.example.app.feature.location.data.model.LocationsResponse
import com.example.app.feature.location.data.remote.LocationsRepository
import com.example.app.feature.location.data.remote.RetrofitClient
import com.example.app.feature.location.presentation.LocationsViewModel
import com.example.app.feature.location.presentation.LocationsViewModelFactory



class LocationFragment: Fragment() {
    private val locationsApi = RetrofitClient.getLocationsApi()

    private val locationsRepository = LocationsRepository(
        locationsApi
    )
    private val locationsViewModelFactory = LocationsViewModelFactory(locationsRepository)

    private val locationsViewModel: LocationsViewModel by activityViewModels {
        locationsViewModelFactory
    }

    private var rawBinding: FragmentLocationBinding? = null
    private val binding get() = rawBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rawBinding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        locationsViewModel.state().observe(this) {
            it?.let { safeLocationResponse ->
                handleUI(safeLocationResponse)
            }
        }
        locationsViewModel.getLocations()
    }

    private fun handleUI(safeLocationResponse: LocationsResponse) {
        val adapter = LocationAdapter(safeLocationResponse.results)
        binding.rvLocation.adapter = adapter

    }

    private fun setupRecyclerView() {
        with(binding){
            rvLocation.layoutManager = LinearLayoutManager(context)
        }
    }

}