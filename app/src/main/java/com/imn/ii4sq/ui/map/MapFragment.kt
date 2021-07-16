package com.imn.ii4sq.ui.map

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import com.imn.ii4sq.R
import com.imn.ii4sq.databinding.FragmentMapBinding
import com.imn.ii4sq.domain.entities.LocationEntity
import com.imn.ii4sq.domain.entities.State
import com.imn.ii4sq.ui.base.BaseFragment
import com.imn.ii4sq.utils.LOCATION_PERMISSIONS
import com.imn.ii4sq.utils.getMapVisibleRadius
import com.imn.ii4sq.utils.getTargetLocation
import org.koin.android.ext.android.inject


class MapFragment : BaseFragment<FragmentMapBinding>() {

    private val mapViewModel: MapViewModel by inject()
    private lateinit var map: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        map = googleMap

        googleMap.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.map_styles),
        )

        map.setOnCameraIdleListener {
            loadVenues(map.getTargetLocation(), map.getMapVisibleRadius())
        }

        requestPermissionLauncher.launch(LOCATION_PERMISSIONS)
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { isGranted ->
        if (
            isGranted.size == LOCATION_PERMISSIONS.size
            && isGranted.values.all { it == true }
        ) {
            listenToMyCurrentLocation()
        } else {
            // TODO handle this
        }
    }

    private fun listenToMyCurrentLocation() {
        mapViewModel.currentLocation.observe(viewLifecycleOwner) {
            when (it) {
                is State.Failure -> {
                    // TODO()
                }
                is State.Loading -> {
                    // TODO()
                }
                is State.Success -> {
                    zoomToCurrentLocation(it.value)
                    // TODO()
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

    private fun loadVenues(location: LocationEntity, radius: Double) {
        mapViewModel.search(location, radius)
        mapViewModel.venuesList.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Failure -> {
                    // TODO()
                }
                is State.Loading -> {
                    // TODO()
                }
                is State.Success -> {

                    state.value.forEach {
                        map.addMarker(
                            MarkerOptions()
                                .position(it.location.toGoogleMapLatLng())
                                .title(it.name)
                        )
                    }
                }
            }
        }
    }

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMapBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}