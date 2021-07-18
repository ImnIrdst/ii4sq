package com.imn.ii4sq.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import com.imn.ii4sq.R
import com.imn.ii4sq.databinding.FragmentMapBinding
import com.imn.ii4sq.domain.entities.LocationEntity
import com.imn.ii4sq.domain.entities.State
import com.imn.ii4sq.domain.entities.Venue
import com.imn.ii4sq.domain.entities.humanReadable
import com.imn.ii4sq.ui.base.BaseFragment
import com.imn.ii4sq.utils.*
import org.koin.android.ext.android.inject


class MapFragment : BaseFragment<FragmentMapBinding>() {

    private lateinit var map: GoogleMap

    private val mapViewModel: MapViewModel by inject()

    private val markerList = mutableListOf<Marker>()
    private val drawnVenues = mutableSetOf<String>()
    private var snackBar: Snackbar? = null

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap

        googleMap.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_styles),
        )

        map.setOnCameraIdleListener {
            mapViewModel.search(map.getTargetLocation(), map.getMapVisibleRadius())
        }

        requestPermissionLauncher.launch(LOCATION_PERMISSIONS)
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { isGranted ->
        if (isGranted.size == LOCATION_PERMISSIONS.size
            && isGranted.values.all { it == true }
        ) {
            listenToMyCurrentLocation()
        } else {
            snackBar = binding.coordinatorLayout.showSnackbar(
                R.string.location_permission_required,
                Snackbar.LENGTH_INDEFINITE,
                R.string.ok
            ) {
                requestLocationPermission()
            }
        }
    }

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMapBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        mapViewModel.venuesList.observe(viewLifecycleOwner) { state ->
            handleVenuesList(state)
        }
    }

    private fun handleVenuesList(state: State<List<Venue>>) = with(binding) {
        when (state) {
            is State.Failure -> {
                loadingView.isVisible = false

                snackBar?.dismiss()
                snackBar = binding.coordinatorLayout.showSnackbar(
                    state.error.humanReadable(requireContext()),
                    Snackbar.LENGTH_INDEFINITE,
                    R.string.retry
                ) {
                    mapViewModel.search(map.getTargetLocation(), map.getMapVisibleRadius())
                }
            }
            is State.Loading -> {
                loadingView.isVisible = true
            }
            is State.Success -> {
                loadingView.isVisible = false

                drawMarkers(state.value)
                removeClearedMarkers()
            }
        }
    }

    private fun drawMarkers(venues: List<Venue>) {
        venues.forEach {
            if (!drawnVenues.contains(it.id)) {
                val marker = map.addMarker(
                    MarkerOptions()
                        .position(it.location.toGoogleMapLatLng())
                        .title(it.name)
                )
                if (marker != null) {
                    marker.tag = it
                    markerList.add(marker)
                }
                drawnVenues.add(it.id)
            }
        }
    }

    private fun removeClearedMarkers() {
        val newMarkerList = mutableListOf<Marker>()
        markerList.forEach {
            if (mapViewModel.isVenueCleared(it.tag as Venue)) {
                it.remove()
                drawnVenues.remove(it.tag)
            } else {
                newMarkerList.add(it)
            }
        }
        markerList.clear()
        markerList.addAll(newMarkerList)
    }

    private fun listenToMyCurrentLocation() = with(binding) {
        mapViewModel.currentLocation.observe(viewLifecycleOwner) {
            when (it) {
                is State.Failure -> {
                    loadingView.isVisible = false
                    snackBar?.dismiss()
                    snackBar = binding.coordinatorLayout.showSnackbar(
                        it.error.humanReadable(requireContext()),
                        Snackbar.LENGTH_INDEFINITE,
                    )
                }
                is State.Loading -> {
                    loadingView.isVisible = true
                }
                is State.Success -> {
                    loadingView.isVisible = false
                    zoomToCurrentLocation(it.value)
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun zoomToCurrentLocation(location: LocationEntity) {
        if (!::map.isInitialized) {
            return
        }
        map.isMyLocationEnabled = true
        map.uiSettings.isMyLocationButtonEnabled = true

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    location.latitude,
                    location.longitude
                ),
                17f
            )
        )
    }

    private fun requestLocationPermission() {
        if (shouldShowRequestPermissionRationaleCompat(LOCATION_PERMISSIONS)) {
            snackBar = binding.coordinatorLayout.showSnackbar(
                R.string.location_permission_required_rationale,
                Snackbar.LENGTH_INDEFINITE,
                R.string.ok
            ) {
                requestPermissionLauncher.launch(LOCATION_PERMISSIONS)
            }
        } else {
            requestPermissionLauncher.launch(LOCATION_PERMISSIONS)
        }
    }
}