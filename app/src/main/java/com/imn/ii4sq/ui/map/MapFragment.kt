package com.imn.ii4sq.ui.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.imn.ii4sq.R
import com.imn.ii4sq.databinding.FragmentMapBinding
import com.imn.ii4sq.ui.base.BaseFragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MapFragment : BaseFragment<FragmentMapBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMapBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMap.setOnClickListener {
            findNavController().navigate(R.id.action_MapFragment_to_VenueDetailsFragment)
        }
    }
}