package com.imn.ii4sq.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.imn.ii4sq.R
import com.imn.ii4sq.databinding.FragmentMapBinding
import com.imn.ii4sq.ui.base.BaseFragment
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MapFragment : BaseFragment<FragmentMapBinding>() {

    private val mapViewModel: MapViewModel by inject()

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMapBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMap.setOnClickListener {
            findNavController().navigate(R.id.action_MapFragment_to_VenueDetailsFragment)
        }
    }
}