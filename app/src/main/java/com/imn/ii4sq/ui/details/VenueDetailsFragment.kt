package com.imn.ii4sq.ui.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.imn.ii4sq.R
import com.imn.ii4sq.databinding.FragmentVenueDetailsBinding
import com.imn.ii4sq.ui.base.BaseFragment

/**
 * A simple [Fragment] subclass as the venue_details destination in the navigation.
 */
class VenueDetailsFragment : BaseFragment<FragmentVenueDetailsBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentVenueDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonVenueDetails.setOnClickListener {
            findNavController().navigate(R.id.action_VenueDetailsFragment_to_MapFragment)
        }
    }
}